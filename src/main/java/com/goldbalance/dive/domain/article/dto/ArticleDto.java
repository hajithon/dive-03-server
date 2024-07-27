package com.goldbalance.dive.domain.article.dto;

import com.goldbalance.dive.domain.article.domain.ArticleContent;
import java.util.List;

public record ArticleDto(String nickname, String title, int totalContents, List<Content> contents) {

    public static ArticleDto of(String nickname, List<ArticleContent> contents) {
        List<Content> contentList = contents.stream()
                .map(articleContent -> new Content(articleContent.getSubTitle(), articleContent.getContent()))
                .toList();

        return new ArticleDto(nickname, contents.get(0).getArticle().getTitle(), contents.size(), contentList);
    }

    static class Content {
        private String subtitle;
        private String content;

        public Content(String subtitle, String content) {
            this.subtitle = subtitle;
            this.content = content;
        }
    }
}
