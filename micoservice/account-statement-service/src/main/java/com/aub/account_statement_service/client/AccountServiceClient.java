package com.aub.account_statement_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aub.account_statement_service.model.Account;

@FeignClient(name = "account-service") // Ensure this matches the service name in Eureka
public interface AccountServiceClient {

    @GetMapping("/accounts")
    Account getAccountByNumber(@RequestParam String accountNumber);
}
