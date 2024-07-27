package com.goldbalance.dive.domain.article.repository;

import com.goldbalance.dive.domain.article.domain.Article;
import com.goldbalance.dive.domain.article.domain.MemberQueryOption;
import com.querydsl.core.types.dsl.BooleanExpression;
import java.util.List;

public interface ArticleCustomRepository {

    List<Article> searchArticle(MemberQueryOption queryOption);

    BooleanExpression containsKeyword(MemberQueryOption queryOption);
}
