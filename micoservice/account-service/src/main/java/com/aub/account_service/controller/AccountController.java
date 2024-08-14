package com.aub.account_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aub.account_service.model.Account;
import com.aub.account_service.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    // @PostMapping("/save")
    // public ResponseEntity<Account> createAccount(@RequestBody Account account){
    //     Account createAccount = accountService.createAccount(account);
    //     return new ResponseEntity<>(createAccount, HttpStatus.CREATED);
    // }

    @PostMapping("/save")
    public ResponseEntity<?> createAccount(@RequestBody Account account) {
        try {
            Account createdAccount = accountService.createAccount(account);
            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception (optional)
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id){
        Account account = accountService.getAccountById(id);
        return account != null? ResponseEntity.ok(account):
        ResponseEntity.notFound().build();
    }

    @GetMapping("/account-number/{accountNumber}")
        public ResponseEntity<Account> getAccountByNumber(@PathVariable String accountNumber){
            Account account = accountService.getAccountByNumber(accountNumber);
            return account != null? ResponseEntity.ok(account):
            ResponseEntity.notFound().build();
        }
    
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account account) {
        account.setId(id);
        Account updatedAccount = accountService.updateAccount(account);
        return ResponseEntity.ok(updatedAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }  
    @PutMapping("/update-balance/{accountNumber}")
    public ResponseEntity<Account> updateBalance(@PathVariable String accountNumber, @RequestParam Double amount) {
        Account updatedAccount = accountService.updateBalance(accountNumber, amount);
        return ResponseEntity.ok(updatedAccount);
    }
}
