package com.aub.deposit_service.service;

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

        public Deposit createDeposit(String accountNumber, Double amount) {
        // Validate account number by calling account-service
        AccountResponse account = accountServiceClient.getAccountByNumber(accountNumber);
        if (account == null || account.getStatus().equals("INACTIVE")) {
            throw new RuntimeException("Account not found or inactive.");
        }

         // Check if the account has sufficient balance
        //  if (account.getBalance() < amount) {
        //     throw new RuntimeException("Insufficient balance.");
        // }

          // Create and save the withdrawal record
        //   Deposit deposit = new Deposit();
        //   deposit.setAccountNumber(accountNumber);
        //   deposit.setAmount(amount);
        //   deposit.setTimestamp(LocalDateTime.now());
        //   deposit.setStatus("active");

        //   return depositRepository.save(deposit);

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

    public List<Deposit> getDepositByAccountNumber(String accountNumber) {
        return depositRepository.findByAccountNumber(accountNumber);
    }

    public Deposit getDepositById(Long id) {
        return depositRepository.findById(id).orElse(null);
    } 
}
