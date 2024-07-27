package com.goldbalance.dive.domain.article.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@RequiredArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Long id;

    private String question;

    private int sequence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    @Builder(access = AccessLevel.PRIVATE)
    private Quiz(String question, int sequence) {
        this.question = question;
        this.sequence = sequence;
    }
}
