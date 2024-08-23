package com.aub.deposit_service.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aub.deposit_service.client.AccountServiceClient;
import com.aub.deposit_service.model.AccountResponse;
import com.aub.deposit_service.model.Deposit;
import com.aub.deposit_service.repository.DepositRepository;

@Service
public class DepositService {
    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private AccountServiceClient accountServiceClient;

        // public Deposit createDeposit(String accountNumber, BigDecimal amount) {
        // // Validate account number by calling account-service
        // AccountResponse account = accountServiceClient.getAccountByNumber(accountNumber);
        // if (account == null || account.getStatus().equals("INACTIVE")) {
        //     throw new RuntimeException("Account not found or inactive.");
        // }

        //  // Check if the account has sufficient balance
        // //  if (account.getBalance() < amount) {
        // //     throw new RuntimeException("Insufficient balance.");
        // // }

        //   // Create and save the withdrawal record
        // //   Deposit deposit = new Deposit();
        // //   deposit.setAccountNumber(accountNumber);
        // //   deposit.setAmount(amount);
        // //   deposit.setTimestamp(LocalDateTime.now());
        // //   deposit.setStatus("active");

        // //   return depositRepository.save(deposit);

        //  // Create and save the deposit record
        //  Deposit deposit = new Deposit();
        //  deposit.setAccountNumber(accountNumber);
        //  deposit.setAmount(amount);
        //  deposit.setTimestamp(LocalDateTime.now());
        //  deposit.setStatus("active");
        //  Deposit savedDeposit = depositRepository.save(deposit);
 
        //  // Update the account balance in the account-service
        //  accountServiceClient.updateBalance(accountNumber, amount);
 
        //  return savedDeposit;

        // }
        
        public Deposit createDeposit(String accountNumber, BigDecimal amount) {
        // Validate account number is not null or empty
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new RuntimeException("Account number is required.");
        }

        // Validate amount is greater than zero
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Deposit amount must be greater than zero.");
        }

        // Validate account number by calling account-service
        AccountResponse account = accountServiceClient.getAccountByNumber(accountNumber);
        if (account == null || account.getStatus().equals("INACTIVE")) {
            throw new RuntimeException("Account not found or inactive.");
        }

        // Create and save the deposit record
        Deposit deposit = new Deposit();
        deposit.setAccountNumber(accountNumber);
        deposit.setAmount(amount);
        deposit.setTimestamp(LocalDateTime.now());
        deposit.setStatus("active");
        Deposit savedDeposit = depositRepository.save(deposit);

        // Update the account balance in the account-service
        accountServiceClient.updateBalance(accountNumber, amount);

        return savedDeposit;
    }


    // public List<Deposit> getDepositByAccountNumber(String accountNumber) {
    //     return depositRepository.findByAccountNumber(accountNumber);
    // }
    public List<Deposit> getDepositByAccountNumber(String accountNumber) {
        // Validate the input
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number must be provided.");
        }
    
        List<Deposit> deposits = depositRepository.findByAccountNumber(accountNumber);
    
        // Check if deposits are found
        if (deposits.isEmpty()) {
            throw new RuntimeException("No deposits found for account number " + accountNumber);
        }
    
        return deposits;
    }


    // public Deposit getDepositById(Long id) {
    //     return depositRepository.findById(id).orElse(null);
    // } 
    public Deposit getDepositById(Long id) {
        return depositRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deposit with ID " + id + " not found."));
    }

   public BigDecimal getTotalDepositsByAccount(String accountNumber) {
        List<Deposit> deposits = depositRepository.findByAccountNumberAndAmountGreaterThan(accountNumber, BigDecimal.ZERO);
        return deposits.stream()
                .map(Deposit::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add); 
                 
    }

}
