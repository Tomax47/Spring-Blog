package com.example.springtest.services;

import com.example.springtest.dto.ArticleDto;
import com.example.springtest.dto.ArticleForm;
import java.util.List;

public interface ArticleService {
    List<ArticleDto> getByUser(Long userId);

    ArticleDto addArticle(Long userId, ArticleForm articleForm);

    // We use the ArticleDto and not the Article cuz in the articleDto we combined the info we need from the User and the Article classes, so we won't have to realize the User object again and call the author's name fe
    ArticleDto like(Long userId, Long articleId);
}
