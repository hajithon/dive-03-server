package com.goldbalance.dive.domain.article.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Quiz {
    @Id @GeneratedValue
    @Column(name = "quiz_id")
    private Long id;

    private String question;

    private int order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    @Builder(access = AccessLevel.PRIVATE)
    private Quiz(String question, int order) {
        this.question = question;
        this.order = order;
    }
}
