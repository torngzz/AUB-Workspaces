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
import com.aub.backend_aub_shop.util.UserSessionUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

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

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Transactional
    public UserModel create(HttpServletRequest request, UserModel user) {
        Optional<UserModel> existingUsername = userRepo.findByUsername(user.getUsername());
        Optional<UserModel> existingEmail = userRepo.findByEmail(user.getEmail());
        if(existingUsername.isPresent()){
            throw new IllegalArgumentException("This username is already existed!");
        }
        else if(existingEmail.isPresent()){
            throw new IllegalArgumentException("This Email is already existed!");
        }
        else{
            HttpSession session = request.getSession();
            Object userAttribute = session.getAttribute("user");
            Object usernameAttribute = UserSessionUtils.getUsername(session);
    
            logger.info("User session attribute: {}", userAttribute);
            logger.info("Username session attribute: {}", usernameAttribute);
    
            // String userID = (userAttribute != null) ? userAttribute.toString() : "defaultUser";
            String id = (usernameAttribute != null) ? usernameAttribute.toString() : "defaultId";
    
            user.setCreatedDate(new Date());
            user.setUpdatedDate(new Date());
            user.setPassword(encryptPassword("123456")); // Encrypt the default password
            user.setCreatedBy(id);
            user.setUpdatedBy(id);
        } 
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

    public UserModel update(UserModel user, Long id, HttpServletRequest request) {
        Optional<UserModel> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            UserModel userModel = optionalUser.get();

            // Check for existing username and email
            Optional<UserModel> existingUsername = userRepo.findByUsername(user.getUsername());
            Optional<UserModel> existingEmail = userRepo.findByEmail(user.getEmail());

            if (existingUsername.isPresent() && !existingUsername.get().getId().equals(id)) {
                throw new IllegalArgumentException("This username is already existed!");
            }
            if (existingEmail.isPresent() && !existingEmail.get().getId().equals(id)) {
                throw new IllegalArgumentException("This email is already existed!");
            }

            HttpSession session = request.getSession();
            String username = UserSessionUtils.getUsername(session);

            // Update user details
            userModel.setUsername(user.getUsername());
            userModel.setRole(user.getRole());
            userModel.setPhone(user.getPhone());
            userModel.setEmail(user.getEmail());
            userModel.setCreatedBy(user.getCreatedBy());
            userModel.setCreatedDate(user.getCreatedDate());
            userModel.setUpdatedDate(new Date());
            userModel.setUpdatedBy(username);

            return userRepo.save(userModel); // Save updated user
        }
        throw new IllegalArgumentException("User not found");
    }
}