package com.aub.e_shop.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aub.e_shop.model.Article;
import com.aub.e_shop.model.Product;
import com.aub.e_shop.repository.ArticleRepository;
import com.aub.e_shop.repository.ProductRepository;
import com.aub.e_shop.service.ArticleService;

@Controller
@RequestMapping(value = {"","/home"})
public class HomeController {
     @Autowired private ArticleService articleService;
     @Autowired private ArticleRepository articleRepository;
     @Autowired private ProductRepository productRepository;


    @GetMapping(value = {"", "/"})
    public String home(Model model) {
        // List<Article> articles = articleService.findTopArticles(); // This method should fetch a subset of articles
        // List<Product> product = productService.findTopViewProducts();

        Pageable articPageable = PageRequest.of(0, 3);
        Pageable pageable = PageRequest.of(0, 3); // For top 6 viewed products
        List<Product> topViewedProducts = productRepository.findTop6ByViewCount(pageable);
        List<Article> topViewArticles = articleRepository.findTopViewArticles(articPageable);
        model.addAttribute("articles", topViewArticles);
        model.addAttribute("products", topViewedProducts);
        return "home";  // Ensure this matches the name of your Thymeleaf template (e.g., home.html)
    }


}
