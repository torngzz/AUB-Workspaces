package com.aub.api_gateway.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.aub.api_gateway.model.User;
import com.aub.api_gateway.service.UserService;

import reactor.core.publisher.Mono;

@Component
public class CustomAuthenticationManager implements ReactiveAuthenticationManager{
    @Autowired 
    private UserService userService;

     private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
    String username = authentication.getName();
    String password = authentication.getCredentials().toString();
    if (username == null || username.isEmpty()) {
        throw new BadCredentialsException("Require username!");
    }
    if(password == null || password.isEmpty()){
        throw new BadCredentialsException("Require password!");
    }
    User user = userService.getUsername(username);
    if (user == null) {
        LOGGER.error("User not found: {}", username);
        throw new BadCredentialsException("Invalid user or password!");
    }

    LOGGER.info("My username: {}", user.getUsername());
    LOGGER.info("My password: {}", user.getPassword());
    LOGGER.info("My role: {}", user.getRole());
    


    // if(!"ABC".equals(username) || !"1234".equals(password)){
    //     throw new BadCredentialsException("Invalid user or password!");
    // }
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    if(!encoder.matches(password, user.getPassword())) {
        throw new BadCredentialsException("Invalid password!");
    }
    password = encoder.encode(password);
    
    List<GrantedAuthority> grantedAuthorities = new ArrayList<>(); 
   // for (String r : user.getRole()) {
    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
   /// }
    Authentication authenticationToken = new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);
    return Mono.just(authenticationToken);
    }

}
