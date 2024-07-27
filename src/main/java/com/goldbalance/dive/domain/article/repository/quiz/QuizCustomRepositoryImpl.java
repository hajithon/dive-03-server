package com.goldbalance.dive.domain.article.repository.quiz;

import static com.goldbalance.dive.domain.article.domain.QAnswer.answer;
import static com.goldbalance.dive.domain.article.domain.QQuiz.quiz;

import com.goldbalance.dive.domain.article.domain.Answer;
import com.goldbalance.dive.domain.article.domain.Quiz;
import com.goldbalance.dive.domain.article.dto.request.QuizRecordRequest;
import com.goldbalance.dive.domain.article.dto.request.QuizRequest;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class QuizCustomRepositoryImpl implements QuizCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Quiz> searchQuiz(Long articleId) {
        return queryFactory
                .selectFrom(quiz)
                .where(quiz.article.id.eq(articleId))
                .fetch();
    }

    @Override
    public List<Answer> getAnswers(QuizRequest quizRequest) {
        List<QuizRecordRequest> quizzes = quizRequest.quizzes();
        return quizzes.stream()
                .map(quizRecord -> queryFactory
                        .selectFrom(answer)
                        .where(answer.quiz.id.eq(quizRecord.quizId()))
                        .fetchOne())
                .collect(Collectors.toList());
    }
}
