package com.goldbalance.dive.domain.article.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    HUMANITIES("인문학"),
    NATURAL_SCIENCES("자연과학"),
    SOCIAL_SCIENCES("사회과학"),
    ARTS_AND_CULTURE("문화예술"),
    ENGINEERING("공학"),
    EDUCATION("교육");

    private final String value;
}
