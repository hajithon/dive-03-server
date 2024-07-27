package com.goldbalance.dive.domain.article.repository.article;

import com.goldbalance.dive.domain.article.domain.Article;
import com.goldbalance.dive.domain.article.dto.request.ArticleQueryOption;
import java.util.List;

public interface ArticleCustomRepository {

    List<Article> searchArticle(ArticleQueryOption queryOption);
}
