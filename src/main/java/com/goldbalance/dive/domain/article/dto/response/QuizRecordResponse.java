package com.goldbalance.dive.domain.article.dto.response;

public record QuizRecordResponse(Long quizId, int number, String submittedAnswer, String correctAnswer) {}
