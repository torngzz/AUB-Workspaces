package com.aub.e_shop.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import okhttp3.OkHttpClient;

@Configuration
public class ConnectionConfig {
    @Bean
    OkHttpClient okHttpClient() {
        long conTimeOut = 120000;
        long readTimeOut = 120000;
        OkHttpClient httpClient = new OkHttpClient.Builder()
        .connectTimeout(conTimeOut, TimeUnit.MILLISECONDS)
        .readTimeout(readTimeOut, TimeUnit.MILLISECONDS)
        .build();
        return httpClient;
    }

}
