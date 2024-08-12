package com.aub.backend_aub_shop.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aub.backend_aub_shop.model.UserModel;
import com.aub.backend_aub_shop.repository.UserRepository;
import com.aub.backend_aub_shop.util.UserSessionUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Service
public class UserService implements UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public String encryptPassword(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
    }

    @Transactional
    public UserModel create(HttpServletRequest request, UserModel user) {
        checkForDuplicateUser(user);

        HttpSession session = request.getSession();
        String id = UserSessionUtils.getUsername(session) != null ? UserSessionUtils.getUsername(session) : "defaultId";

        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());
        user.setPassword(encryptPassword("123456")); // Encrypt the default password
        user.setCreatedBy(id);
        user.setUpdatedBy(id);

        return userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("Loading user by username: {}", username);
        UserModel user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }

    public UserModel findUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public Page<UserModel> findAll(String username, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return username == null || username.trim().isEmpty() 
            ? userRepo.findAll(pageable)
            : userRepo.findByUsername(username, pageable);
    }

    public List<UserModel> findAll() {
        return userRepo.findAll();
    }

    public Optional<UserModel> findById(Long id) {
        return userRepo.findById(id);
    }

    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    @Transactional
    public UserModel update(UserModel user, Long id, HttpServletRequest request) {
        UserModel userModel = userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        checkForDuplicateUser(user, id);

        HttpSession session = request.getSession();
        String username = UserSessionUtils.getUsername(session);

        userModel.setUsername(user.getUsername());
        userModel.setRole(user.getRole());
        userModel.setPhone(user.getPhone());
        userModel.setEmail(user.getEmail()); 
        userModel.setUpdatedDate(new Date());
        userModel.setUpdatedBy(username);

        LOGGER.info("Updating user with ID: {}. Preserving createdDate: {}", id, userModel.getCreatedDate());

        return userRepo.save(userModel);
    }

    private void checkForDuplicateUser(UserModel user) {
        if (userRepo.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("This username already exists!");
        }
        if (userRepo.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("This email already exists!");
        }
        if (userRepo.existsByPhone(user.getPhone())) {
            throw new IllegalArgumentException("This phone number already exists!");
        }
    }

    private void checkForDuplicateUser(UserModel user, Long id) {
        Optional<UserModel> existingUser = userRepo.findByUsernameOrEmailOrPhoneAndIdNot(user.getUsername(), user.getEmail(), user.getPhone(), id);
        if (existingUser.isPresent()) {
            UserModel existing = existingUser.get();
            if (!existing.getId().equals(id)) {
                if (!existing.getUsername().equals(user.getUsername())) {
                    throw new IllegalArgumentException("This username already exists!");
                }
                if (!existing.getEmail().equals(user.getEmail())) {
                    throw new IllegalArgumentException("This email already exists!");
                }
                if (!existing.getPhone().equals(user.getPhone())) {
                    throw new IllegalArgumentException("This phone number already exists!");
                }
            }
        }
    }
}
