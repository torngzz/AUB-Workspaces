package com.aub.backend_aub_shop.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserService implements UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public String encryptPassword(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
    }

    public UserModel create(HttpServletRequest request, UserModel user) {
        String userID = request.getSession().getAttribute("user").toString();
        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());
        user.setPassword(encryptPassword("123456"));
        user.setCreatedBy("Admin");
        user.setUpdatedBy("None");
        user.setUsername(userID); // Set username based on request/session attribute
        return userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("It's working here.");
        UserModel user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user; // UserModel implements UserDetails
    }

    public UserModel findUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username).get();
    }

    public Page<UserModel> findAll(String username, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);    
        if (username == null || username.trim().isEmpty()) {
            return userRepo.findAll(pageable);
        }
        return userRepo.findByUsername(username, pageable);
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

    public UserModel update(UserModel user, Long id) {
        Optional<UserModel> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            UserModel userModel = optionalUser.get();
            userModel.setUsername(user.getUsername()); // Update username
            userModel.setRole(user.getRole()); // Update role
            userModel.setPhone(user.getPhone()); // Update phone
            userModel.setEmail(user.getEmail()); // Update email
            userModel.setUpdatedDate(new Date(System.currentTimeMillis())); // Update date
            return userRepo.save(userModel); // Save updated user
        }
        return null;
    }
}