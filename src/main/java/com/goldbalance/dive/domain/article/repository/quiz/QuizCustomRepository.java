package com.goldbalance.dive.domain.article.repository.quiz;

import com.goldbalance.dive.domain.article.domain.Answer;
import com.goldbalance.dive.domain.article.domain.Quiz;
import com.goldbalance.dive.domain.article.dto.request.QuizRequest;
import java.util.List;

public interface QuizCustomRepository {
    List<Quiz> searchQuiz(Long articleId);

    List<Answer> getAnswers(QuizRequest quizRequest);
}
