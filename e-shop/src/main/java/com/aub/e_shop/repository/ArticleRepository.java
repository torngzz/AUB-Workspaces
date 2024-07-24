package com.aub.e_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aub.e_shop.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{

}
