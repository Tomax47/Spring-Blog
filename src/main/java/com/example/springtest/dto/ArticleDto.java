package com.example.springtest.dto;

import com.example.springtest.model.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDto {
    private Long id;
    private String text;
    private String authorName;
    private Integer likesCount;

    public static ArticleDto from(Article article) {
        return ArticleDto.builder()
                .id(article.getArticle_id())
                .text(article.getText())
                .authorName(article.getAuthor().getEmail())
                .likesCount(article.getLikes().size())
                .build();
    }

    public static List<ArticleDto> articlesList(List<Article> articles) {
        return articles.stream()
                .map(ArticleDto::from)
                .collect(Collectors.toList());
    }
}
