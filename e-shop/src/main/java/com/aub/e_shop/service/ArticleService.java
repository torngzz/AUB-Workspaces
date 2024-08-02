package com.aub.e_shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aub.e_shop.model.Article;
import com.aub.e_shop.repository.ArticleRepository;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public Page<Article> findAll(int pageNumber, int pageSize) 
    {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return articleRepository.findAll(pageable);
    }

    public Optional<Article> getById(Long id) {
        return articleRepository.findById(id);
    }

    public void incrementViewCount(Long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
            Long currentViewCount = article.getViewCount();
            if (currentViewCount == null) {
                currentViewCount = 0L;
            }
            article.setViewCount(currentViewCount + 1);
            articleRepository.save(article);
        }
    }
    
    public List<Article> findTopArticles() {
        return articleRepository.findAll(PageRequest.of(0, 3)).getContent(); // Fetch top 3 articles for example
    }

}
