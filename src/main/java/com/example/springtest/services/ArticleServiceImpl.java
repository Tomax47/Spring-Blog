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
                .name(articleForm.getName())
                .author(author)
                .text(articleForm.getText())
                .build();

        articleRepo.save(newArticle);
        return ArticleDto.from(newArticle);
    }

    @Override
    public ArticleDto like(Long userId, Long articleId) {
        User user = userRepo.getOne(userId);
        Article article = articleRepo.getOne(articleId);

        if (articleRepo.existsByArticleIdAndLikesContaining(articleId, user)) {
            // The user has already liked the article -> unlike
            article.getLikes().remove(user);
        } else {
            // The user ain't liked the article -> like
            article.getLikes().add(user);
        }

        // To update the article's likes List! "It won't save the article as a new record in the DB"
        articleRepo.save(article);
        return ArticleDto.from(article);
    }
}
