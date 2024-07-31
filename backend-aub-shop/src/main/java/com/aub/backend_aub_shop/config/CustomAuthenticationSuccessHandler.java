package com.aub.backend_aub_shop.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.aub.backend_aub_shop.model.UserModel;
import com.aub.backend_aub_shop.model.UserSessionManager;
import com.aub.backend_aub_shop.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        try {
            HttpSession session = request.getSession();
            // get authentication details;
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            LOGGER.info("Exception has occurred: " + userDetails.getUsername());

            UserModel user = userService.findUserByUsername(userDetails.getUsername());
            UserSessionManager u = new UserSessionManager(user.getId(), user.getUsername());
            // Set user data in session
            session.setAttribute("UserSessionManager", u); // assuming UserModel has getId() method

            session.setAttribute("authorities", authentication.getAuthorities());

        } catch (UsernameNotFoundException e) {
            LOGGER.error("Exception has occurred: " + e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.error("Exception has occurred", e);
            response.sendRedirect("/error");
        }
        response.sendRedirect("/backendaubshop");
    }
}
