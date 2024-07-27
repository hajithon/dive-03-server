package com.goldbalance.dive.domain.article.repository.article;

import static com.goldbalance.dive.domain.article.domain.QArticle.*;
import static com.goldbalance.dive.domain.article.domain.QQuiz.*;

import com.goldbalance.dive.domain.article.domain.Article;
import com.goldbalance.dive.domain.article.domain.Quiz;
import com.goldbalance.dive.domain.article.dto.request.ArticleQueryOption;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticleCustomRepositoryImpl implements ArticleCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Article> searchArticle(ArticleQueryOption queryOption) {
        return queryFactory
                .selectFrom(article)
                .where(containsKeyword(queryOption))
                .fetch();
    }

    @Override
    public List<Quiz> searchQuiz(Long articleId) {
        return queryFactory
                .selectFrom(quiz)
                .where(quiz.article.id.eq(articleId))
                .fetch();
    }

    private BooleanExpression containsKeyword(ArticleQueryOption queryOption) {
        return queryOption.keyword() != null ? article.title.containsIgnoreCase(queryOption.keyword()) : null;
    }
}
