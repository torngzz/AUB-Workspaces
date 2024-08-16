package com.aub.account_summary_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AccountSummaryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountSummaryServiceApplication.class, args);
	}

}
