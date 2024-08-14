package com.aub.api_gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder){
        return builder.routes()
            .route("account-service", r -> r
                    .path("/aub/accounts/**")
            .filters(f -> f.stripPrefix(1))
                    .uri("lb://account-service"))

            .route("withdrawal-service", r -> r
                    .path("/aub/withdrawals/**")
            .filters(f -> f.stripPrefix(1))
                    .uri("lb://withdrawal-service"))

                    
            .route("deposit-service", r -> r
                .path("/aub/deposit-service/**")
            .filters(f -> f.stripPrefix(1))
                .uri("lb://deposit-service"))

            .build();
    }
    
}
