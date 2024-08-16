package com.aub.account_summary_service;

import java.util.List;
import java.util.Optional;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.aub.account_summary_service.model.AccountSummary;
import com.aub.account_summary_service.repository.AccountSummaryRepository;
import com.aub.account_summary_service.repository.TransactionRepository;

import jakarta.transaction.Transaction;

@Service
public class AccountSummaryService {
    @Autowired
    private AccountSummaryRepository accountSummaryRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public Optional<AccountSummary> getAccountSummary(Long accountId) {
        return accountSummaryRepository.findById(accountId);
    }

    public List<Transaction> getRecentTransactions(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
}
