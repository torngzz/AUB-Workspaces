package com.aub.withdrawal_service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aub.withdrawal_service.client.AccountServiceClient;
import com.aub.withdrawal_service.model.AccountResponse;
import com.aub.withdrawal_service.model.WithdrawalModel;
import com.aub.withdrawal_service.repository.WithdrawalRepository;

@Service
public class WithdrawalService {
    @Autowired
    private WithdrawalRepository withdrawalRepository; 

    @Autowired
     AccountServiceClient accountServiceClient;

    public WithdrawalModel createWithdrawal(String accountNumber, Double amount) {
        // Fetch account details from account-service
        AccountResponse account = accountServiceClient.getAccountByNumber(accountNumber);
        System.out.println("account="+account.getAccountNumber());
        if (account == null || "INACTIVE".equals(account.getStatus())) {
            throw new RuntimeException("Account not found or inactive.");
        }

        // Check if the account has sufficient balance
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance.");
        }

        // Create and save the withdrawal record
        WithdrawalModel withdrawal = new WithdrawalModel();
        withdrawal.setAccountNumber(accountNumber);
        withdrawal.setAmount(amount);
        withdrawal.setTimestamp(LocalDateTime.now());
        withdrawal.setStatus("COMPLETED");

        // Save the withdrawal record to the database
        return withdrawalRepository.save(withdrawal);
    }

    public List<WithdrawalModel> getWithdrawalsByAccountNumber(String accountNumber) {
        return withdrawalRepository.findByAccountNumber(accountNumber);
    }

    public WithdrawalModel getWithdrawalById(Long id) {
        return withdrawalRepository.findById(id).orElse(null);
    }

}
