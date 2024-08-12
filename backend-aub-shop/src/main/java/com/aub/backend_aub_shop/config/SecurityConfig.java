package com.aub.backend_aub_shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity //Enables method-level security using annotations like @PreAuthorize, @PostAuthorize, etc.
public class SecurityConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    private final AuthenticationSuccessHandler customAuthenticationSuccessHandler;
    private final AccessDeniedHandler accessDeniedHandler;

    public SecurityConfig(CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler, AccessDeniedHandler accessDeniedHandler) {
        this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
        this.accessDeniedHandler = accessDeniedHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .formLogin((form) -> form
            .loginPage("/login")
            .permitAll()
            .failureHandler(new CustomeFailerHandler())
            .successHandler(customAuthenticationSuccessHandler)
        )
        .logout((logout) -> logout
            .logoutUrl("/logout")
            //.logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
            .logoutSuccessUrl("/login?logout")
            .permitAll()
        )
        .authorizeHttpRequests((requests) -> requests
            .anyRequest().hasRole("Admin")
        )
        .exceptionHandling((exceptions)->exceptions
            .accessDeniedHandler(accessDeniedHandler)
        );
        return http.build();
    }
}