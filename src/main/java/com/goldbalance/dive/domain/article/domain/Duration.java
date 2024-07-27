package com.goldbalance.dive.domain.article.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Duration {
    LESS_THAN_5_MINUTES("5분 미만", 0L),
    BETWEEN_5_AND_20_MINUTES("5분 ~ 20분 미만", 5L),
    MORE_THAN_20_MINUTES("20분 이상", 10L);

    private final String description;
    private final Long mileage;
}
