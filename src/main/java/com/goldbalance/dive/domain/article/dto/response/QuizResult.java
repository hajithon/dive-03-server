package com.goldbalance.dive.domain.article.dto.response;

import java.util.List;

public record QuizResult(
        String nickname, // member
        int earnedMileages, // 직접 구하기ㅣ
        int totalMileages, // member
        int totalQuizzes, // quizRequest
        int correctQuizzes, // 직접 구하기
        String title, // 직접 입력
        List<QuizRecordResponse> response //
        ) {
    static class QuizRecordResponse {
        Long quizId;
        int number;
        String submittedAnswer;
        String correctAnswer;

        public QuizRecordResponse(Long quizId, int number, String submittedAnswer) {
            this.quizId = quizId;
            this.number = number;
            this.submittedAnswer = submittedAnswer;
            this.correctAnswer = submittedAnswer;
        }
    }
}
