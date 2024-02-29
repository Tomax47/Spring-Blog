package com.example.springtest.controller;

import com.example.springtest.dto.ArticleDto;
import com.example.springtest.dto.ArticleForm;
import com.example.springtest.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @PostMapping("/users/{user-id}/articles")
    @ResponseBody
    public ArticleDto addArticle(@PathVariable("user-id") Long userId, // To show that it ain't just a thing in the url added, but a variable of a connected user
                                 @RequestBody ArticleForm articleForm) {
        return articleService.addArticle(userId, articleForm);
    }
    // localhost:8080/users/1/articles
    @GetMapping("/users/{user-id}/articles")
    public String getArticlesOfUser(@PathVariable("user-id") Long userId, Model model) {
        model.addAttribute("articles", articleService.getByUser(userId));
        return "articles_page";
    }
}
