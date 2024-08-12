package com.aub.api_gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aub.api_gateway.model.User;
import com.aub.api_gateway.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * 
     * @param userName
     * @return
     */
    public User getUsername(String userName){
        return userRepository.findByUsername(userName);
    }
    
}