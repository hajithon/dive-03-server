package com.goldbalance.dive.domain.article.repository.quiz;

import com.goldbalance.dive.domain.article.domain.Quiz;
import java.util.List;

public interface QuizCustomRepository {
    List<Quiz> searchQuiz(Long articleId);
}
