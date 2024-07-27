package com.goldbalance.dive.domain.article.service;

import com.goldbalance.dive.domain.article.domain.Article;
import com.goldbalance.dive.domain.article.domain.MemberQueryOption;
import com.goldbalance.dive.domain.article.repository.ArticleRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> findArticles(MemberQueryOption queryOption) {
        return articleRepository.searchArticle(queryOption);
    }
}
