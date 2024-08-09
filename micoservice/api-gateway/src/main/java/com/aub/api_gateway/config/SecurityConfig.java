package com.aub.api_gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig extends GlobalAuthenticationConfigurerAdapter {
    @Autowired CustomBasicAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired CustomAuthenticationManager authenticationManager;
    @Autowired CustomServerAccessDeniedHandler accessDeniedHandler;

    @Bean
    SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable() 
        .authorizeExchange(exchage -> exchage
        .pathMatchers("/aub/accounts/**").hasRole("USER")
        //.pathMatchers("/test/**").permitAll()
        .anyExchange().authenticated()
        )
        .exceptionHandling(deny-> deny.accessDeniedHandler(accessDeniedHandler))
        .authenticationManager(authenticationManager)
        .headers(headers -> headers
        .contentSecurityPolicy(csp -> csp.policyDirectives("frame-ancestors 'self'")))
        .httpBasic(httpBasic -> httpBasic.authenticationEntryPoint(authenticationEntryPoint))
        );
        return http.build();

    }
}
