package com.goldbalance.dive.domain.article.repository;

import com.goldbalance.dive.domain.article.domain.Article;
import java.util.List;

public interface ArticleCustomRepository {
    List<Article> findAllArticles();

    List<Article> searchArticle(String input);
}
