package com.aub.transfer_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aub.transfer_service.model.AccountResponse;

@FeignClient(name="account-service")
public interface AccountServiceClient {

    @GetMapping("/accounts/account-number/{accountNumber}")
    AccountResponse getAccountByNumber(@PathVariable("accountNumber") String accountNumber); 

    // @GetMapping("/accounts")
    // ResponseEntity<List<AccountResponse>> getAllAccounts();

    @PutMapping("/accounts/account-number/{accountNumber}/decrease-balance")
    void decreaseBalance(@PathVariable("accountNumber") String accountNumber, @RequestParam("amount") Double amount);

    @PutMapping("/accounts/account-number/{accountNumber}/increase-balance")
    void increaseBalance(@PathVariable("accountNumber") String accountNumber, @RequestParam("amount") Double amount);
}
