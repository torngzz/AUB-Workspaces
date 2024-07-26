package com.aub.backend_aub_shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.aub.backend_aub_shop.model.ProductList_Model;

public interface ProductRepository extends JpaRepository<ProductList_Model, Long>{
    // @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
   public List<ProductList_Model> findByNameContainingIgnoreCase(@Param("name") String name);
   // List<Product> findByNameContainingIgnoreCase(String name);
}
