package com.goldbalance.dive.domain.article.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Option {
    A("Option A"),
    B("Option B"),
    C("Option C"),
    D("Option D");

    private final String name;
}
