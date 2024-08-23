package com.aub.e_shop.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aub.e_shop.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{
    @Query("SELECT a FROM Article a ORDER BY a.viewCount DESC")
    List<Article> findTopViewArticles(Pageable pageable);

    // List<Article> findAll(Pageable pageable);

}
