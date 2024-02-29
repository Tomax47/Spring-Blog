package com.example.springtest.services;

import com.example.springtest.dto.ArticleDto;
import com.example.springtest.dto.ArticleForm;
import com.example.springtest.model.Article;
import com.example.springtest.model.User;
import com.example.springtest.repository.ArticleRepo;
import com.example.springtest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ArticleRepo articleRepo;
    @Override
    public List<ArticleDto> getByUser(Long userId) {
        User user = userRepo.getOne(userId);
        List<Article> userArticles = user.getCreatedArticles();
        return ArticleDto.articlesList(userArticles);
    }

    public ArticleDto addArticle(Long userId, ArticleForm articleForm) {
        User author = userRepo.getOne(userId);

        Article newArticle = Article.builder()
                .author(author)
                .text(articleForm.getText())
                .build();

        articleRepo.save(newArticle);
        return ArticleDto.from(newArticle);
    }
}
