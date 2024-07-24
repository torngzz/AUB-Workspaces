package com.aub.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aub.login.model.loginModel;
import com.aub.login.repository.loginRepository;

@Service
public class loginService {
    @Autowired 
    private loginRepository loginRepo;

    // @Autowired
    // private BCryptPasswordEncoder passwordEncoder;  // Ensure this bean is configured

    // public loginModel login(String user, String pwd) {
    //     loginModel userModel = loginRepo.findByUsername(user);
        
    //     if (userModel != null && passwordEncoder.matches(pwd, userModel.getPassword())) {
    //         return userModel; // Authentication successful
    //     }
        
    //     return null; // Authentication failed
    // }

    public List<loginModel> findAll(){
      return loginRepo.findAll();
    }

    public loginModel save(loginModel login){
      return loginRepo.save(login);
    }
}
