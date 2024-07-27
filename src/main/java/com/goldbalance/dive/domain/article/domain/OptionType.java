package com.goldbalance.dive.domain.article.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum OptionType {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4");

    private final String number;
}
