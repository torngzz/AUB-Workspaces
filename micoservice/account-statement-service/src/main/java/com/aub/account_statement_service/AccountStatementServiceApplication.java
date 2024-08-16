package com.aub.account_statement_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // This annotation enables Feign clients
public class AccountStatementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountStatementServiceApplication.class, args);
	}

}
