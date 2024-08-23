package com.aub.withdrawal_service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aub.withdrawal_service.client.AccountServiceClient;
import com.aub.withdrawal_service.model.AccountResponse;
import com.aub.withdrawal_service.model.WithdrawalModel;
import com.aub.withdrawal_service.repository.WithdrawalRepository;

@Service
public class WithdrawalService {
    private final static Logger LOGGER = LoggerFactory.getLogger(WithdrawalService.class);
    @Autowired
    private WithdrawalRepository withdrawalRepository; 

    @Autowired
     AccountServiceClient accountServiceClient;

    // public WithdrawalModel createWithdrawal(String accountNumber, Double amount) {
    //     // Fetch account details from account-service
    //     AccountResponse account = accountServiceClient.getAccountByNumber(accountNumber);
    //     LOGGER.info("MY RESPONSE: "+ account.toString());
    //     System.out.println("account="+account.getAccountNumber());
    //     if (null == account || "INACTIVE".equals(account.getStatus())) {
    //         throw new RuntimeException("Account not found or inactive.");
    //     }

    //     // Check if the account has sufficient balance
    //     if (account.getBalance() < amount) {
    //         throw new RuntimeException("Insufficient balance.");
    //     }

    //     // Create and save the withdrawal record
    //     WithdrawalModel withdrawal = new WithdrawalModel();
    //     withdrawal.setAccountNumber(accountNumber);
    //     withdrawal.setAmount(amount);
    //     // withdrawal.setAccountType(accouyntType);
    //     withdrawal.setTimestamp(LocalDateTime.now());
    //     withdrawal.setStatus("COMPLETED");
    //     //save accout-service
    //     //oldbalice
    //     Double oldBalance = account.getBalance();
    //     Double remainBalance = oldBalance - amount;

    //     account.setBalance(remainBalance);

    //     LOGGER.info("accountNumber" + account.toString());
    //     accountServiceClient.updateAccount(account.getId(), account);

    //     // Save the withdrawal record to the database
    //     return withdrawalRepository.save(withdrawal);
    // }
    public WithdrawalModel createWithdrawal(String accountNumber, Double amount) {
    // Fetch account details from account-service
    AccountResponse account = accountServiceClient.getAccountByNumber(accountNumber);
    LOGGER.info("MY RESPONSE: " + account.toString());
    System.out.println("account=" + account.getAccountNumber());

    // Check if the account is null or inactive
    if (account == null || "INACTIVE".equals(account.getStatus())) {
        throw new RuntimeException("Account with account number " + accountNumber + " not found or inactive.");
    }

    // Check if the account has sufficient balance
    if (account.getBalance() < amount) {
        throw new RuntimeException("Insufficient balance in account with account number " + accountNumber + ".");
    }

    // Create and save the withdrawal record
    WithdrawalModel withdrawal = new WithdrawalModel();
    withdrawal.setAccountNumber(accountNumber);
    withdrawal.setAmount(amount);
    withdrawal.setTimestamp(LocalDateTime.now());
    withdrawal.setStatus("COMPLETED");

    // Update account balance
    Double oldBalance = account.getBalance();
    Double remainBalance = oldBalance - amount;
    account.setBalance(remainBalance);
    LOGGER.info("Updated account balance: " + account.toString());

    // Save updated account details
    accountServiceClient.updateAccount(account.getId(), account);

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
