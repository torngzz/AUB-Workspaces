// package com.aub.login.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class securityConfig {

//     @Bean
//     public BCryptPasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         return http
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/").permitAll()
//                 .requestMatchers("/contact").permitAll()
//                 .requestMatchers("/store**").permitAll()
//                 .requestMatchers("/register").permitAll()
//                 .requestMatchers("/login").permitAll()
//                 .requestMatchers("/logout").permitAll()
//                 .anyRequest().authenticated()
//             )
//             .formLogin(form -> form
//                 .defaultSuccessUrl("/", true)
//             )
//             .logout(config -> config.logoutSuccessUrl("/"))
//             .build();
//     }
// }
