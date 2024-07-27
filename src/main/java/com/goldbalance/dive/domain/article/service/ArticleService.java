package com.goldbalance.dive.domain.article.service;

import com.goldbalance.dive.domain.article.domain.Article;
import com.goldbalance.dive.domain.article.domain.ArticleContent;
import com.goldbalance.dive.domain.article.domain.Quiz;
import com.goldbalance.dive.domain.article.dto.ArticleDto;
import com.goldbalance.dive.domain.article.dto.request.ArticleQueryOption;
import com.goldbalance.dive.domain.article.dto.request.QuizRequest;
import com.goldbalance.dive.domain.article.dto.response.QuizResult;
import com.goldbalance.dive.domain.article.repository.ArticleContentRepository;
import com.goldbalance.dive.domain.article.repository.article.ArticleRepository;
import com.goldbalance.dive.domain.article.repository.quiz.QuizRepository;
import com.goldbalance.dive.domain.member.repository.MemberRepository;
import com.goldbalance.dive.global.exception.CustomException;
import com.goldbalance.dive.global.exception.ErrorCode;
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
    private final MemberRepository memberRepository;

    public List<Article> findArticles(ArticleQueryOption queryOption) {
        return articleRepository.searchArticle(queryOption);
    }

    public List<Quiz> findQuizzes(Long articleId) {
        return quizRepository.searchQuiz(articleId);
    }

    public ArticleDto getArticleContents(String nickname, Long articleId) {
        List<ArticleContent> articleContents = articleContentRepository.findAllByArticleId(articleId);
        if (articleContents.isEmpty()) {
            throw new CustomException(ErrorCode.ARTICLE_NOT_FOUND);
        }
        return ArticleDto.of(nickname, articleContents);
    }

    public QuizResult getQuizResult(String nickname, QuizRequest quizRequest) {
        return null;
    }
}
