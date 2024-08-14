package com.aub.transfer_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aub.transfer_service.model.AccountResponse;

@FeignClient(name="account-service")
public interface AccountServiceClient {

    @GetMapping("/accounts/account-number/{accountNumber}")
    AccountResponse getAccountByNumber(@PathVariable("accountNumber") String accountNumber); 

    // @GetMapping("/accounts")
    // ResponseEntity<List<AccountResponse>> getAllAccounts();
}
