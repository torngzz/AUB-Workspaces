package com.aub.backend_aub_shop.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.aub.backend_aub_shop.model.UserModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

 @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // Cast UserDetails to UserModel if needed
        UserModel userModel = (UserModel) userDetails;

        // Set user data in session
        request.getSession().setAttribute("userId", userModel.getId()); // assuming UserModel has getId() method
        request.getSession().setAttribute("username", userModel.getUsername());
        request.getSession().setAttribute("userRole", userModel.getRole());

        // Redirect to the home page or a default page
        response.sendRedirect("/home");
    }
}
