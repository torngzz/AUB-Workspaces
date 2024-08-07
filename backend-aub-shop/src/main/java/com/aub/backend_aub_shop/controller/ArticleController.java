package com.aub.backend_aub_shop.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aub.backend_aub_shop.model.ArticleModel;
import com.aub.backend_aub_shop.service.ArticleService;

@Controller
@RequestMapping("/Article")
public class ArticleController {
    @Autowired 
    private ArticleService articleService;

    @GetMapping("/list")
    public String get(
        @RequestParam(name = "pageNumber", defaultValue= "0") int pageNumber,
        @RequestParam(name = "pageSize", defaultValue= "5") int pageSize,
        Model m) {
        Page<ArticleModel> articles = articleService.findAll(pageNumber, pageSize);
        m.addAttribute("articles", articles);
        m.addAttribute("currentPage", pageNumber);
        m.addAttribute("pagesize", pageSize);
        m.addAttribute("totalPages", articles.getTotalPages());
        return "article-list"; // Ensure this matches the template name
    }
    
    @GetMapping("/add")
    public String showAddArticleForm(Model model) {
        model.addAttribute("article", new ArticleModel());
        return "add-article";
    }

    @PostMapping("/add")
    public String addArticle(@ModelAttribute ArticleModel article) {
        article.setCreatedDate(new Date());
        articleService.save(article);
        return "redirect:/Article/list";
    }

    @GetMapping("/details/{id}")
    public String getArticleDetails(@PathVariable("id") Long id, Model model) {
        ArticleModel article = articleService.findById(id);
        model.addAttribute("article", article);
        return "article-details";
}

}
