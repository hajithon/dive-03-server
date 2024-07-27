package com.goldbalance.dive.domain.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MileageType {
    ATTENDANCE("출석"),
    READ_ARTICLE("글 읽기"),
    QUIZ_CORRECT("퀴즈 정답");

    private final String mileageTypeName;
}
