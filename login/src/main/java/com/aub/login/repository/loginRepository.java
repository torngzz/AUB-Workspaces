package com.aub.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aub.login.model.loginModel;

public interface loginRepository extends JpaRepository<loginModel, Long> {
    // loginModel findByUsername(String username);
}
