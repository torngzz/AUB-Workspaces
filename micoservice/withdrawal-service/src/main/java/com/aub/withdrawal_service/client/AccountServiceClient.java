package com.aub.withdrawal_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.aub.withdrawal_service.model.AccountResponse;

@FeignClient(name = "account-service")

public interface AccountServiceClient {

    @GetMapping("/accounts/account-number/{accountNumber}")
    AccountResponse getAccountByNumber(@PathVariable("accountNumber") String accountNumber);
  
    
    @PutMapping("/accounts/{id}")
    public ResponseEntity<AccountResponse> updateAccount(@PathVariable Long id, @RequestBody AccountResponse account);
        


}