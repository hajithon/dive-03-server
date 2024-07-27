package com.goldbalance.dive.domain.article.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@RequiredArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private OptionType optionType;

    private String content;

    private boolean correct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @Builder(access = AccessLevel.PRIVATE)
    private Answer(OptionType optionType, String content, boolean correct) {
        this.optionType = optionType;
        this.content = content;
        this.correct = correct;
    }
}
