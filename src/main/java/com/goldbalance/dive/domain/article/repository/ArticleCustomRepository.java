package com.goldbalance.dive.domain.article.repository;

import com.goldbalance.dive.domain.article.domain.Article;
import com.goldbalance.dive.domain.article.domain.ArticleQueryOption;
import java.util.List;

public interface ArticleCustomRepository {

    List<Article> searchArticle(ArticleQueryOption queryOption);
}
