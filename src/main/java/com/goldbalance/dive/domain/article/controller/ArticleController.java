package com.goldbalance.dive.domain.article.controller;

import com.goldbalance.dive.domain.article.domain.Article;
import com.goldbalance.dive.domain.article.domain.ArticleQueryOption;
import com.goldbalance.dive.domain.article.service.ArticleService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<Article>> findArticles(@RequestParam ArticleQueryOption queryOption) {
        List<Article> response = articleService.findArticles(queryOption);
        return ResponseEntity.ok(response);
    }
}
