package com.goldbalance.dive.domain.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MileageType {
    ATTENDANCE("출석", 5L),
    READ_ARTICLE("글 읽기", 5L),
    QUIZ_CORRECT("퀴즈 정답", 5L);

    private final String mileageTypeName;
    private final Long mileage;
}
