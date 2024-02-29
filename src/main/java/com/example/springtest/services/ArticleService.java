package com.example.springtest.services;

import com.example.springtest.dto.ArticleDto;
import com.example.springtest.dto.ArticleForm;
import java.util.List;

public interface ArticleService {
    List<ArticleDto> getByUser(Long userId);

    ArticleDto addArticle(Long userId, ArticleForm articleForm);
}
