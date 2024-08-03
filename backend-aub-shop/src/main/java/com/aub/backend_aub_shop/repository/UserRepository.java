package com.aub.backend_aub_shop.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.aub.backend_aub_shop.model.UserModel;


public interface UserRepository extends JpaRepository<UserModel, Long> {
    public Page<UserModel> findByUsername(@Param("username") String username, Pageable pageable);
    Optional<UserModel> findByUsername(String username);
    Optional<UserModel> findByEmail(String email);
    // @Query("SELECT um FROM UserModel um LEFT JOIN FETCH um.createdBy LEFT JOIN FETCH um.updatedBy WHERE um.username LIKE %:username%")
    // Page<UserModel> findAllWithUsers(@Param("username") String username, Pageable pageable);
}
