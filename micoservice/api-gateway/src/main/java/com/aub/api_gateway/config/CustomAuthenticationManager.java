package com.aub.api_gateway.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class CustomAuthenticationManager implements ReactiveAuthenticationManager{
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

    if(!"ABC".equals(username) || !"1234".equals(password)){
        throw new BadCredentialsException("Invalid user or password!");
    }
    //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    // if(!encoder.matches(password, user.getUserPass())) {
   
    // throw new BadCredentialsException("Invalid password!");
    // }
    // password = encoder.encode(password);
    
    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    // for (String r : user.getRoles()) {
    // grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + r));
    // }
    Authentication authenticationToken = new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);
    return Mono.just(authenticationToken);
    }

}
