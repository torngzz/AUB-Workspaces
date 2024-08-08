package com.aub.backend_aub_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aub.backend_aub_shop.model.ArticleModel;

public interface ArticleRepository extends JpaRepository<ArticleModel, Long> {
}
