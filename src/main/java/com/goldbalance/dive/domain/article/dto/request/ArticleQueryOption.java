package com.goldbalance.dive.domain.article.dto.request;

import com.goldbalance.dive.domain.article.domain.Category;
import com.goldbalance.dive.domain.article.domain.Duration;

public record ArticleQueryOption(String keyword, Category category, Duration duration) {}
