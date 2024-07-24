package com.aub.e_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aub.e_shop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
