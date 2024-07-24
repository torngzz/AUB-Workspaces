package com.aub.backend_aub_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aub.backend_aub_shop.model.User_Model;

public interface UserRepository extends JpaRepository<User_Model, Long> {
  
}
