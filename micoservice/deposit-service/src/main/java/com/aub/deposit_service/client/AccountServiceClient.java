package com.aub.deposit_service.client;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aub.deposit_service.model.AccountResponse;

// @EnableFeignClients(name = "account-service")
@FeignClient(name="account-service")
public interface AccountServiceClient {

    @GetMapping("/accounts/account-number/{accountNumber}")
    AccountResponse getAccountByNumber(@PathVariable("accountNumber") String accountNumber); 

    @GetMapping("/accounts")
    ResponseEntity<List<AccountResponse>> getAllAccounts();
}
