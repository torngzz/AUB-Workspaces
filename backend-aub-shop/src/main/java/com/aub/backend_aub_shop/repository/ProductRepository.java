package com.aub.backend_aub_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aub.backend_aub_shop.model.ProductList_Model;

public interface ProductRepository extends JpaRepository<ProductList_Model, Long>{
    
}
