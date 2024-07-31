package com.aub.backend_aub_shop.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.aub.backend_aub_shop.util.BcryptUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomeFailerHandler implements AuthenticationFailureHandler{
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
            LOGGER.info("It's failure now.");
            System.out.println(BcryptUtil.encrypt("123456"));
        throw new UnsupportedOperationException("Unimplemented method 'onAuthenticationFailure'");
    }
    

}
