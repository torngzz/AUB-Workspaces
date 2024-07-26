package com.aub.backend_aub_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aub.backend_aub_shop.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
  
}
