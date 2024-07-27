package com.goldbalance.dive.domain.article.repository;

import com.goldbalance.dive.domain.article.domain.ArticleContent;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleContentRepository extends JpaRepository<ArticleContent, Long> {

    List<ArticleContent> findAllByArticleId(Long articleId);
}
