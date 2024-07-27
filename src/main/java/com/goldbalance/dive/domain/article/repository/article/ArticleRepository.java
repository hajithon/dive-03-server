package com.goldbalance.dive.domain.article.repository.article;

import com.goldbalance.dive.domain.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long>, ArticleCustomRepository {}
