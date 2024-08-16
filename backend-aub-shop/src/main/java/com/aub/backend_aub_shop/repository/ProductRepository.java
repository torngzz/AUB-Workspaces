package com.aub.backend_aub_shop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aub.backend_aub_shop.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    // @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
   public List<Product> findByproductNameContainingIgnoreCase(@Param("name") String name);

   Page<Product> findBycreatebyUsernameContaining(String username, Pageable pageable);

  
}
