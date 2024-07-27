package com.goldbalance.dive.domain.article.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class Article {
    @Id @GeneratedValue
    @Column(name = "article_id")
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Duration duration;

    @Builder(access = AccessLevel.PRIVATE)
    private Article(String title, Category category, Duration duration) {
        this.title = title;
        this.category = category;
        this.duration = duration;
    }
}
