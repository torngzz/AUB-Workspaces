package com.aub.deposit_service.client;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aub.deposit_service.model.AccountResponse;

// @EnableFeignClients(name = "account-service")
@FeignClient(name="account-service")
public interface AccountServiceClient {

    @GetMapping("/accounts/account-number/{accountNumber}")
    AccountResponse getAccountByNumber(@PathVariable("accountNumber") String accountNumber); 

    @GetMapping("/accounts")
    ResponseEntity<List<AccountResponse>> getAllAccounts();

    @PutMapping("/accounts/update-balance/{accountNumber}")
    void updateBalance(@PathVariable("accountNumber") String accountNumber, @RequestParam BigDecimal amount);


    
}
