package com.goldbalance.dive.domain.article.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@RequiredArgsConstructor
public class ArticleContent {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "subtitle")
    private String subTitle;

    @Column(length = 600)
    private String content;

    @Column(name = "content_order")
    private int order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    @Builder(access = AccessLevel.PRIVATE)
    private ArticleContent(String subTitle, String content, int order) {
        this.subTitle = subTitle;
        this.content = content;
        this.order = order;
    }
}
