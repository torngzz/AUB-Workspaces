package com.aub.e_shop.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aub.e_shop.model.Article;
import com.aub.e_shop.service.ArticleService;

@Controller
@RequestMapping(value = {"","/home"})
public class HomeController {
     @Autowired
    private ArticleService articleService;

    @GetMapping(value = {"", "/"})
    public String home(Model model) {
        List<Article> articles = articleService.findTopArticles(); // This method should fetch a subset of articles
        model.addAttribute("articles", articles);
        return "home";  // Ensure this matches the name of your Thymeleaf template (e.g., home.html)
    }

}
