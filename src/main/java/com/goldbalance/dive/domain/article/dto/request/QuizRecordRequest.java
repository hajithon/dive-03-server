package com.goldbalance.dive.domain.article.dto.request;

import com.goldbalance.dive.domain.article.domain.OptionType;

public record QuizRecordRequest(Long quizId, int number, OptionType answer) {}
