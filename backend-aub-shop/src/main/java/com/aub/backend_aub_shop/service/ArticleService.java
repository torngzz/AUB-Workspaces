package com.aub.backend_aub_shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aub.backend_aub_shop.model.ArticleModel;
import com.aub.backend_aub_shop.repository.ArticleRepository;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public Page<ArticleModel> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return articleRepository.findAll(pageable);
    }

    public Optional<ArticleModel> getById(Long id) {
        return articleRepository.findById(id);
    }
    
    public List<ArticleModel> findTopArticles() {
        return articleRepository.findAll(PageRequest.of(0, 3)).getContent(); // Fetch top 3 articles for example
    }

    public void save(ArticleModel article) {
        articleRepository.save(article);
    }

    public ArticleModel findById(Long id) {
        return articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));
    }
    
}
