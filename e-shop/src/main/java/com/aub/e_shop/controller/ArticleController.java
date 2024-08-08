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
    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    public String get(
        @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
        @RequestParam(name = "pageSize", defaultValue = "5") int pageSize,
        Model model) {

        Page<Article> articles = articleService.findAll(pageNumber, pageSize);
        model.addAttribute("articles", articles);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", articles.getTotalPages());

        return "article-form"; // Corrected to match the template name
    }

    @GetMapping("/details/{id}")
    public String getArticleDetails(@PathVariable Long id, Model model) {
        // Increment view count before fetching the article details
        articleService.incrementViewCount(id);
        Optional<Article> article = articleService.getById(id);
        if (article.isPresent()) {
            model.addAttribute("article", article.get());
            return "article-details"; // Ensure this matches the template name
        } else {
            return "redirect:/Article/list"; // Corrected the redirection URL
        }
    }

}

