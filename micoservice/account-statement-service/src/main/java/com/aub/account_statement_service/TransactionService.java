package com.aub.account_statement_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aub.account_statement_service.client.AccountServiceClient;
import com.aub.account_statement_service.model.Account;
import com.aub.account_statement_service.model.TransactionModel;
import com.aub.account_statement_service.repository.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountServiceClient accountServiceClient; // Ensure this is correctly injected

    public List<TransactionModel> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public TransactionModel getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public TransactionModel saveTransaction(TransactionModel transactionModel) {
        return transactionRepository.save(transactionModel);
    }

    public TransactionModel updateTransaction(Long id, TransactionModel transactionModel) {
        if (transactionRepository.existsById(id)) {
            transactionModel.setId(id);
            return transactionRepository.save(transactionModel);
        }
        return null; // Or throw an exception
    }

    public void deleteTransaction(Long id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
        }
    }

    public Account getAccountDetails(String accountNumber) {
        return accountServiceClient.getAccountByNumber(accountNumber);
    }
}
