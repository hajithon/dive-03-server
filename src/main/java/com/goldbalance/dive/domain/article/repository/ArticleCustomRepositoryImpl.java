package com.goldbalance.dive.domain.article.repository;

import static com.goldbalance.dive.domain.article.domain.QArticle.*;

import com.goldbalance.dive.domain.article.domain.Article;
import com.goldbalance.dive.domain.article.domain.ArticleQueryOption;
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

    private BooleanExpression containsKeyword(ArticleQueryOption queryOption) {
        return queryOption.keyword() != null ? article.title.containsIgnoreCase(queryOption.keyword()) : null;
    }
}