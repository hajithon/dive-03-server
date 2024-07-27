package com.goldbalance.dive.domain.article.dto.request;

import java.util.List;

public record QuizRequest(String nickname, int totalQuizzes, List<QuizRecordRequest> quizzes) {}
