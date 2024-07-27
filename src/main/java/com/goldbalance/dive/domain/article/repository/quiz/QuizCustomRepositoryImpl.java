package com.goldbalance.dive.domain.article.repository.quiz;

import static com.goldbalance.dive.domain.article.domain.QQuiz.quiz;

import com.goldbalance.dive.domain.article.domain.Quiz;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
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
}
