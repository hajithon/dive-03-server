package com.goldbalance.dive.domain.article.service;

import static com.goldbalance.dive.domain.member.domain.MileageType.*;
import static com.goldbalance.dive.global.exception.ErrorCode.*;

import com.goldbalance.dive.domain.article.domain.Answer;
import com.goldbalance.dive.domain.article.domain.Article;
import com.goldbalance.dive.domain.article.domain.ArticleContent;
import com.goldbalance.dive.domain.article.domain.Quiz;
import com.goldbalance.dive.domain.article.dto.ArticleDto;
import com.goldbalance.dive.domain.article.dto.request.ArticleQueryOption;
import com.goldbalance.dive.domain.article.dto.request.QuizRecordRequest;
import com.goldbalance.dive.domain.article.dto.request.QuizRequest;
import com.goldbalance.dive.domain.article.dto.response.QuizRecordResponse;
import com.goldbalance.dive.domain.article.dto.response.QuizResult;
import com.goldbalance.dive.domain.article.repository.AnswerRepository;
import com.goldbalance.dive.domain.article.repository.ArticleContentRepository;
import com.goldbalance.dive.domain.article.repository.article.ArticleRepository;
import com.goldbalance.dive.domain.article.repository.quiz.QuizRepository;
import com.goldbalance.dive.domain.member.domain.Member;
import com.goldbalance.dive.domain.member.domain.Mileage;
import com.goldbalance.dive.domain.member.repository.MemberRepository;
import com.goldbalance.dive.domain.member.repository.MileageRepository;
import com.goldbalance.dive.global.exception.CustomException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleContentRepository articleContentRepository;
    private final QuizRepository quizRepository;
    private final AnswerRepository answerRepository;
    private final MemberRepository memberRepository;
    private final MileageRepository mileageRepository;

    public List<Article> findArticles(ArticleQueryOption queryOption) {
        return articleRepository.searchArticle(queryOption);
    }

    public List<Quiz> findQuizzes(Long articleId) {
        return quizRepository.searchQuiz(articleId);
    }

    public ArticleDto getArticleContents(String nickname, Long articleId) {
        List<ArticleContent> articleContents = articleContentRepository.findAllByArticleId(articleId);
        if (articleContents.isEmpty()) {
            throw new CustomException(ARTICLE_NOT_FOUND);
        }
        return ArticleDto.of(nickname, articleContents);
    }

    public QuizResult gradeQuizzes(Long articleId, QuizRequest quizRequest) {
        Article article =
                articleRepository.findById(articleId).orElseThrow(() -> new CustomException(ARTICLE_NOT_FOUND));
        Member member = memberRepository
                .findByNickname(quizRequest.nickname())
                .orElseThrow(() -> new CustomException(MEMBER_NOT_FOUND));

        List<QuizRecordRequest> quizzes = quizRequest.quizzes();
        long earnedMileages = 0;
        int correctQuizzes = 0;

        List<QuizRecordResponse> quizRecordResponses = new ArrayList<>();
        for (QuizRecordRequest q : quizzes) {
            Answer answer =
                    answerRepository.findByQuizId(q.quizId()).orElseThrow(() -> new CustomException(ANSWER_NOT_FOUND));
            if (q.answer().equals(answer.getOptionType())) {
                earnedMileages += QUIZ_CORRECT.getMileage();
                correctQuizzes += 1;
            }
            quizRecordResponses.add(new QuizRecordResponse(
                    q.quizId(),
                    q.number(),
                    q.answer().getNumber(),
                    answer.getOptionType().getNumber()));
        }

        member.addMileages(earnedMileages);
        Mileage mileage = Mileage.create(member, earnedMileages, QUIZ_CORRECT);
        mileageRepository.save(mileage);

        return QuizResult.of(
                member,
                earnedMileages,
                quizRecordResponses.size(),
                correctQuizzes,
                article.getTitle(),
                quizRecordResponses);
    }
}
