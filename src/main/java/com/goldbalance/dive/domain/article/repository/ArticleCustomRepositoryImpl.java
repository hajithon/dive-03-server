package com.goldbalance.dive.domain.article.repository;

import static com.goldbalance.dive.domain.article.domain.QArticle.*;

import com.goldbalance.dive.domain.article.domain.Article;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticleCustomRepositoryImpl implements ArticleCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Article> findAllArticles() {
        return queryFactory.selectFrom(article).fetch();
    }

    @Override
    public List<Article> searchArticle(String input) {
        return queryFactory
                .selectFrom(article)
                .where(article.title.containsIgnoreCase(input))
                .fetch();
    }
}
