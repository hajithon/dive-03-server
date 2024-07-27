package com.goldbalance.dive.domain.article.service;

import com.goldbalance.dive.domain.article.domain.Article;
import com.goldbalance.dive.domain.article.domain.Quiz;
import com.goldbalance.dive.domain.article.dto.request.ArticleQueryOption;
import com.goldbalance.dive.domain.article.repository.article.ArticleRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> findArticles(ArticleQueryOption queryOption) {
        return articleRepository.searchArticle(queryOption);
    }

    public List<Quiz> findQuizzes(Long articleId) {
        return articleRepository.searchQuiz(articleId);
    }
}
