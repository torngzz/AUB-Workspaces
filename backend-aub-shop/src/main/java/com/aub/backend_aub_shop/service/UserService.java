package com.aub.backend_aub_shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aub.backend_aub_shop.model.User_Model;
import com.aub.backend_aub_shop.repository.UserRepository;

@Service
public class UserService {
  @Autowired UserRepository userRepo;

  /**
   * 
   * @return
   */
  public List<User_Model> findAll(){
    return userRepo.findAll();
  }

  public Optional<User_Model> findById(Long id){
    return userRepo.findById(id);
  }

  public User_Model create(User_Model user){
    return userRepo.save(user);
  }

  public void deleteById(Long id){
    userRepo.deleteById(id);
  }

  public User_Model update(User_Model user, Long id){
    Optional<User_Model> optionalUser = userRepo.findById(id);
    if(optionalUser.isPresent()){
      User_Model userModel = optionalUser.get();
      userModel.setUsername(userModel.getUsername());
      userModel.setPassword(userModel.getPassword());
      userModel.setRole(userModel.getRole());
      userModel.setPhone(userModel.getPhone());
      userModel.setEmail(userModel.getEmail());
      userModel.setCreatedBy(userModel.getCreatedBy());
      userModel.setCreatedDate(userModel.getCreatedDate());
      userModel.setUpdatedBy(userModel.getUpdatedBy());
      userModel.setUpdatedBy(userModel.getUpdatedBy());
      return userRepo.save(userModel);
    }
    return null;
  }
}
