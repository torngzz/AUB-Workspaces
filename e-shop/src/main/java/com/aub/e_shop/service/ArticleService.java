package com.aub.e_shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aub.e_shop.model.Article;
import com.aub.e_shop.repository.ArticleRepository;

@Service
public class ArticleService {
    @Autowired private ArticleRepository articleRepository;

    public List<Article> findAll()
    {
        return articleRepository.findAll();
    }
    public Optional<Article> getById(Long id)
    {
        return articleRepository.findById(id);
    }
}
