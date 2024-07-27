package com.goldbalance.dive.domain.article.controller;

import com.goldbalance.dive.domain.article.domain.Article;
import com.goldbalance.dive.domain.article.service.ArticleService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<Article>> findAllArticles() {
        List<Article> articleList = articleService.findAllArticles();
        return ResponseEntity.ok(articleList);
    }

    @PostMapping
    public ResponseEntity<?> createArticle(@RequestBody String input) {
        List<Article> articleList = articleService.findArticlesByInput(input);
        if (!articleList.isEmpty()) {
            return ResponseEntity.ok(articleList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
