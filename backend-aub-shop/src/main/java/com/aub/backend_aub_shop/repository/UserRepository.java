package com.aub.backend_aub_shop.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aub.backend_aub_shop.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUsername(String username);

    Optional<UserModel> findByEmail(String email);

    Optional<UserModel> findByPhone(String phone);

    Page<UserModel> findByUsername(String username, Pageable pageable);

    Optional<UserModel> findByUsernameOrEmailOrPhoneAndIdNot(String username, String email, String phone, Long id);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);
}
