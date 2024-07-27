package com.goldbalance.dive.domain.article.repository.article;

import static com.goldbalance.dive.domain.article.domain.QArticle.*;
import static com.goldbalance.dive.domain.article.domain.QQuiz.*;

import com.goldbalance.dive.domain.article.domain.Article;
import com.goldbalance.dive.domain.article.domain.Category;
import com.goldbalance.dive.domain.article.domain.Duration;
import com.goldbalance.dive.domain.article.dto.request.ArticleQueryOption;
import com.querydsl.core.BooleanBuilder;
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
                .where(matchesQueryOption(queryOption))
                .fetch();
    }

    private BooleanExpression containsKeyword(String keyword) {
        return keyword != null ? article.title.containsIgnoreCase(keyword) : null;
    }

    private BooleanExpression eqCategory(Category category) {
        return category != null ? article.category.eq(category) : null;
    }

    private BooleanExpression eqDuration(Duration duration) {
        return duration != null ? article.duration.eq(duration) : null;
    }

    private BooleanBuilder matchesQueryOption(ArticleQueryOption queryOption) {
        return new BooleanBuilder()
                .and(containsKeyword(queryOption.keyword()))
                .and(eqCategory(queryOption.category()))
                .and(eqDuration(queryOption.duration()));
    }
}
