package com.aub.deposit_service.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aub.deposit_service.client.AccountServiceClient;
import com.aub.deposit_service.model.AccountResponse;
import com.aub.deposit_service.model.Deposit;
import com.aub.deposit_service.service.DepositService;

@RestController
@RequestMapping("/deposit-service")
public class DepositController {
    @Autowired
    private DepositService depositService;

    @Autowired
    private AccountServiceClient accountServiceClient;


    // Use  @RequestParam 

    // @PostMapping("/make-deposit")
    // public ResponseEntity<Deposit> createDeposit(
    //         @RequestParam String accountNumber,
    //         @RequestParam BigDecimal amount) {

    //     Deposit deposit = depositService.createDeposit(accountNumber, amount);
    //     return new ResponseEntity<>(deposit, HttpStatus.CREATED);

    //     // try {
    //     //     Deposit deposit = depositService.createDeposit(accountNumber, amount);
    //     //     return ResponseEntity.ok(deposit);
    //     // } catch (RuntimeException e) {
    //     //     return ResponseEntity.badRequest().body(null);
    //     // }
    // }

    //use RequestBody
    @PostMapping("/make-deposit")
    // public ResponseEntity<Deposit> createDeposit(@RequestBody Deposit deposit) {
    //     // Extract accountNumber and amount from the request body
    //     String accountNumber = deposit.getAccountNumber();
    //     BigDecimal amount = deposit.getAmount();

    //     // Create the deposit
    //     Deposit createdeposit = depositService.createDeposit(accountNumber, amount);

    //     // Return the response
    //     return new ResponseEntity<>(createdeposit, HttpStatus.CREATED);
    // }

        public ResponseEntity<?> createDeposit(@RequestBody Deposit deposit) {
            try {
                // Extract accountNumber and amount from the request body
                String accountNumber = deposit.getAccountNumber();
                BigDecimal amount = deposit.getAmount();

                // Validate input fields before proceeding
                if (accountNumber == null || accountNumber.trim().isEmpty()) {
                    throw new IllegalArgumentException("Account number is required.");
                }
                if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
                    throw new IllegalArgumentException("Deposit amount must be greater than zero.");
                }

                // Create the deposit
                Deposit createdDeposit = depositService.createDeposit(accountNumber, amount);

                // Return the response
                return new ResponseEntity<>(createdDeposit, HttpStatus.CREATED);

            } catch (IllegalArgumentException ex) {
                // Return a bad request response for validation errors
                return ResponseEntity.badRequest().body("Error: " + ex.getMessage());

            } catch (RuntimeException ex) {
                // Handle custom exceptions like account not found or inactive
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());

            } catch (Exception ex) {
                // Handle general errors or unexpected exceptions
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred: " + ex.getMessage());
            }
        }

    @GetMapping("/account/{accountNumber}")
    // public ResponseEntity<List<Deposit>> getDepositByAccountNumber(@PathVariable String accountNumber) {
    //     List<Deposit> deposit = depositService.getDepositByAccountNumber(accountNumber);
    //     return ResponseEntity.ok(deposit);
    // }
    public ResponseEntity<?> getDepositsByAccountNumber(@PathVariable String accountNumber) {
        try {
            // Retrieve deposits by account number
            List<Deposit> deposits = depositService.getDepositByAccountNumber(accountNumber);
    
            // Return deposits if found
            return ResponseEntity.ok(deposits);
    
        } catch (IllegalArgumentException ex) {
            // Handle illegal argument exceptions and return bad request response
            return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
    
        } catch (RuntimeException ex) {
            // Handle runtime exceptions and return not found response
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + ex.getMessage());
    
        } catch (Exception ex) {
            // Handle general errors or unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }

    @GetMapping("/{id}")
    // public ResponseEntity<Deposit> getDepositById(@PathVariable Long id) {
    //     Deposit deposit = depositService.getDepositById(id);
    //     return deposit != null ? ResponseEntity.ok(deposit) : ResponseEntity.notFound().build();
    // }
    public ResponseEntity<?> getDepositById(@PathVariable Long id) {
        try {
            Deposit deposit = depositService.getDepositById(id);
            return ResponseEntity.ok(deposit);
    
        } catch (RuntimeException ex) {   
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + ex.getMessage());
    
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }
    
    @GetMapping("/accounts")
    public ResponseEntity<List<AccountResponse>> getAllAccounts(){
        return accountServiceClient.getAllAccounts();
    }

    // @GetMapping("/api/deposits/total/{accountNumber}")
    // public ResponseEntity<Double> getTotalDepositsByAccount(@PathVariable String accountNumber) {
    //     Double totalDeposits = depositService.getTotalDepositsByAccount(accountNumber);
    //     return ResponseEntity.ok(totalDeposits);
    // }
     @GetMapping("/total-deposits/{accountNumber}")
    public ResponseEntity<BigDecimal> getTotalDepositsByAccount(@PathVariable String accountNumber) {
        BigDecimal totalDeposits = depositService.getTotalDepositsByAccount(accountNumber);
        return ResponseEntity.ok(totalDeposits);
    }
}
