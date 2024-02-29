package com.example.springtest.repository;

import com.example.springtest.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article, Long> {
}
