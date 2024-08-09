package com.aub.api_gateway.config;

import java.nio.charset.StandardCharsets;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class CustomBasicAuthenticationEntryPoint implements ServerAuthenticationEntryPoint {
    @Override
    public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException ex) {
    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
    exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
    String jsonResponse = "{\"status\": \"FAIL\", \"code\": \"7207001\", \"message\": \"Unauthorized\"}";
    DataBufferFactory dataBufferFactory = exchange.getResponse().bufferFactory();
    DataBuffer dataBuffer = dataBufferFactory.wrap(jsonResponse.getBytes(StandardCharsets.UTF_8));
    return exchange.getResponse().writeWith(Mono.just(dataBuffer));

    }
}
