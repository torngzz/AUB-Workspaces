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
@RequestMapping("/Article")
public class ArticleController {
    @Autowired ArticleService articleService;

    @GetMapping("/list")
    public String get(Model m){
        List<Article> articles = articleService.findAll();
        System.out.println("hiii" + articles.toString());
        m.addAttribute("articles", articles);
        return "article-form";


        
    }
}
