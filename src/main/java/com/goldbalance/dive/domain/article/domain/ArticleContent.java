package com.goldbalance.dive.domain.article.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * <br>package name   : com.goldbalance.dive.domain.article.domain
 * <br>file name      : ArticleContent
 * <br>date           : 2024-07-27
 * <pre>
 * <span style="color: white;">[description]</span>
 *
 * </pre>
 * <pre>
 * <span style="color: white;">usage:</span>
 * {@code
 *
 * } </pre>
 * <pre>
 * modified log :
 * =======================================================
 * DATE           AUTHOR               NOTE
 * -------------------------------------------------------
 * 2024-07-27        SeungHoon              init create
 * </pre>
 */
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
