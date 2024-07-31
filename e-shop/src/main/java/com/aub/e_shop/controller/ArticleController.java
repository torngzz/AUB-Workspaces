package com.aub.e_shop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aub.e_shop.model.Article;
import com.aub.e_shop.service.ArticleService;

@Controller
@RequestMapping("/Article")
public class ArticleController {
    @Autowired ArticleService articleService;

    @GetMapping("/list")
    public String get(
    @RequestParam(name = "pageNumber", defaultValue= "0") int pageNumber,
    @RequestParam(name = "pageSize", defaultValue= "2") int pageSize,
    Model m)

    {
        Page<Article> articles = articleService.findAll(pageNumber, pageSize);
        System.out.println("hiii" + articles.toString());
        m.addAttribute("articles", articles);
        m.addAttribute("currentPage", pageNumber);
        m.addAttribute("pageize", pageSize);
        m.addAttribute("totalPages", articles.getTotalPages());

        return "article-form";
        
    }

    @GetMapping("/details/{id}")
    public String getArticleDetails(@PathVariable Long id, Model m) {
        // Increment view count before fetching the article details
        articleService.incrementViewCount(id);
        Optional<Article> article = articleService.getById(id);
        if (article.isPresent()) {
            m.addAttribute("article", article.get());
            return "article-details";
        } else {
            return "redirect:/Article/list";
        }
    }

}

