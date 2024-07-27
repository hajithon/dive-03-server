package com.goldbalance.dive.domain.article.controller;

import com.goldbalance.dive.domain.article.domain.Article;
import com.goldbalance.dive.domain.article.domain.Quiz;
import com.goldbalance.dive.domain.article.dto.ArticleDto;
import com.goldbalance.dive.domain.article.dto.request.ArticleQueryOption;
import com.goldbalance.dive.domain.article.dto.request.QuizRequest;
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

    @GetMapping("/quizzes/{articleId}")
    public ResponseEntity<List<Quiz>> findQuizzes(@PathVariable Long articleId, @RequestBody String nickname) {
        List<Quiz> response = articleService.findQuizzes(articleId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<ArticleDto> getArticleContents(@PathVariable Long articleId, @RequestBody String nickname) {
        ArticleDto response = articleService.getArticleContents(nickname, articleId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/quizzes/{articleId}")
    public ResponseEntity<?> getQuizResult(@PathVariable Long articleId, @RequestBody QuizRequest quizRequest) {
        return ResponseEntity.ok().build();
    }
}
