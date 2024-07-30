package com.aub.backend_aub_shop.service;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aub.backend_aub_shop.model.UserModel;
import com.aub.backend_aub_shop.repository.UserRepository;

@Service
public class UserService {
  @Autowired UserRepository userRepo;

  /***
   * 
   * @param username
   * @param pageNumber
   * @param pageSize
   * @return
   */
  public Page<UserModel> findAll(String username, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);    
        if (username == null || username.trim().isEmpty()) {
            return userRepo.findAll(pageable);
        }
        return userRepo.findByUsername(username, pageable);
  }

    /**
   * Find all without using Pagination
   * @return
   */
  public List<UserModel> findAll(){
    return userRepo.findAll();
  }
  
  /**
   * 
   * @param id
   * @return
   */
  public Optional<UserModel> findById(Long id){
    return userRepo.findById(id);
  }

  /***
   * 
   * @param user
   * @return
   */
  public UserModel create(UserModel user) {
      user.setCreatedDate(new Date(System.currentTimeMillis()));
      user.setUpdatedDate(new Date(System.currentTimeMillis()));
      user.setPassword(generateRandomPassword(6));
      return userRepo.save(user);
  }

      /**
     * Generates a random password of the specified length.
     * 
     * @param length
     * @return
     */
    private String generateRandomPassword(int length) {
        final String characters = "1234567890";
        // final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_+=<>?";
        Random random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }
        
        return password.toString();
    }

  /**
   * 
   * @param id
   */
  public void deleteById(Long id){
    userRepo.deleteById(id);
  }

  /**
   * 
   * @param user
   * @param id
   * @return
   */
  public UserModel update(UserModel user, Long id){
    Optional<UserModel> optionalUser = userRepo.findById(id);
    if(optionalUser.isPresent()){
      UserModel userModel = optionalUser.get();
      userModel.setUsername(user.getUsername());
      //userModel.setPassword(user.getPassword());
      userModel.setRole(user.getRole());
      userModel.setPhone(user.getPhone());
      userModel.setEmail(user.getEmail());
      // userModel.setCreatedBy(user.getCreatedBy());
      // userModel.setCreatedDate(user.getCreatedDate());
      // userModel.setUpdatedBy(user.getUpdatedBy());
      userModel.setUpdatedDate(new Date(System.currentTimeMillis()));
      return userRepo.save(userModel);
    }
    return null;
  }
}