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
import com.aub.account_service.repository.AccountRepository;
import com.aub.account_service.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired 
    private AccountRepository accountRepository;

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

    // @GetMapping("/{id}")
    // public ResponseEntity<Account> getAccountById(@PathVariable Long id){
    //     Account account = accountService.getAccountById(id);
    //     return account != null? ResponseEntity.ok(account):
    //     ResponseEntity.notFound().build();
    // }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable Long id) {
        try {
            // Attempt to fetch the account by ID
            Account account = accountService.getAccountById(id);
            return new ResponseEntity<>(account, HttpStatus.OK);
        } catch (RuntimeException ex) {
            // Return a 404 NOT FOUND response with the error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + ex.getMessage());
        } catch (Exception ex) {
            // Return a 500 INTERNAL SERVER ERROR response for unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred: " + ex.getMessage());
        }
    }

    @GetMapping("/account-number/{accountNumber}")
        // public ResponseEntity<Account> getAccountByNumber(@PathVariable String accountNumber){
        //     Account account = accountService.getAccountByNumber(accountNumber);
        //     return account != null? ResponseEntity.ok(account):
        //     ResponseEntity.notFound().build();
        // }
        public ResponseEntity<?> getAccountByNumber(@PathVariable String accountNumber) {
            try {
                Account account = accountService.getAccountByNumber(accountNumber);
                return new ResponseEntity<>(account, HttpStatus.OK);
            } catch (RuntimeException ex) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + ex.getMessage());
            } catch (Exception ex) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred: " + ex.getMessage());
            }
        }
    
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @PutMapping("/{id}")
    // public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account account) {
    //     account.setId(id);
    //     Account updatedAccount = accountService.updateAccount(account);
    //     return ResponseEntity.ok(updatedAccount);
    // }
    public ResponseEntity<?> updateAccount(@PathVariable Long id, @RequestBody Account account) {
        try {
            // Set the ID from the path variable to ensure the correct account is updated
            account.setId(id);
    
            // Attempt to update the account after validations
            Account updatedAccount = accountService.updateAccount(account);
    
            // Return the updated account with an OK status
            return ResponseEntity.ok(updatedAccount);
    
        } catch (RuntimeException ex) {
            // Catch any validation or runtime exceptions and return a BAD REQUEST status
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error: " + ex.getMessage());
        } catch (Exception ex) {
            // Handle any unexpected exceptions and return an INTERNAL SERVER ERROR status
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + ex.getMessage());
        }
    }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
    //     accountService.deleteAccount(id);
    //     return ResponseEntity.noContent().build();
    // }  
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long id) {
        try {
            // Call the service method to delete the account
            String resultMessage = accountService.deleteAccount(id);

            // Return success message with OK status
            return ResponseEntity.ok(resultMessage);

        } catch (RuntimeException ex) {
            // Catch any validation or runtime exceptions and return a BAD REQUEST status
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error: " + ex.getMessage());
        } catch (Exception ex) {
            // Handle any unexpected exceptions and return an INTERNAL SERVER ERROR status
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + ex.getMessage());
        }
    }

    //when deposit update balance in account
    @PutMapping("/update-balance/{accountNumber}")
    public ResponseEntity<Account> updateBalance(@PathVariable String accountNumber, @RequestParam Double amount) {
        Account updatedAccount = accountService.updateBalance(accountNumber, amount);
        return ResponseEntity.ok(updatedAccount);
    }

    //two function work when transfer between account
    @PutMapping("/account-number/{accountNumber}/decrease-balance")
    public void decreaseBalance(@PathVariable("accountNumber") String accountNumber, @RequestParam("amount") Double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account != null) {
            account.setBalance(account.getBalance() - amount);
            accountRepository.save(account);
        }
    }

    @PutMapping("/account-number/{accountNumber}/increase-balance")
    public void increaseBalance(@PathVariable("accountNumber") String accountNumber, @RequestParam("amount") Double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            accountRepository.save(account);
        }
    }
    //end

}
