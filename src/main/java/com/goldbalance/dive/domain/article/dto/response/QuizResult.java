package com.goldbalance.dive.domain.article.dto.response;

import com.goldbalance.dive.domain.member.domain.Member;
import java.util.List;

public record QuizResult(
        String nickname,
        long earnedMileages,
        long totalMileages,
        int totalQuizzes,
        int correctQuizzes,
        String title,
        List<QuizRecordResponse> response) {

    public static QuizResult of(
            Member member,
            long earnedMileages,
            int totalQuizzes,
            int correctQuizzes,
            String title,
            List<QuizRecordResponse> response) {
        return new QuizResult(
                member.getNickname(),
                earnedMileages,
                member.getTotalMileage(),
                totalQuizzes,
                correctQuizzes,
                title,
                response);
    }
}
