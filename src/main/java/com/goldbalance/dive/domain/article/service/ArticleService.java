package com.goldbalance.dive.domain.article.service;

import com.goldbalance.dive.domain.article.domain.Article;
import com.goldbalance.dive.domain.article.domain.ArticleContent;
import com.goldbalance.dive.domain.article.domain.ArticleQueryOption;
import com.goldbalance.dive.domain.article.dto.ArticleDto;
import com.goldbalance.dive.domain.article.repository.ArticleContentRepository;
import com.goldbalance.dive.domain.article.repository.ArticleRepository;
import com.goldbalance.dive.global.exception.CustomException;
import com.goldbalance.dive.global.exception.ErrorCode;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleContentRepository articleContentRepository;

    public List<Article> findArticles(ArticleQueryOption queryOption) {
        return articleRepository.searchArticle(queryOption);
    }

    public ArticleDto getArticleContents(String nickname, Long articleId) {
        List<ArticleContent> articleContents = articleContentRepository.findAllByArticleId(articleId);
        if (articleContents.isEmpty()) {
            throw new CustomException(ErrorCode.ARTICLE_NOT_FOUND);
        }
        return ArticleDto.of(nickname, articleContents);
    }
}
