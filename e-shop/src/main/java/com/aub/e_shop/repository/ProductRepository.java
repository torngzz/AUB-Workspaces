package com.aub.e_shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aub.e_shop.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
     //Page<Category> findByCategoryId(Long id, Pageable pageable);
    Page<Product> findBycategory_id(Long category_id, Pageable pageable);
}
