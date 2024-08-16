package com.aub.account_summary_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aub.account_summary_service.AccountSummaryService;
import com.aub.account_summary_service.model.AccountSummary;

import jakarta.transaction.Transaction;

@RestController
@RequestMapping("/summary")
public class AccountSummaryController {
    @Autowired
    private AccountSummaryService accountSummaryService;

    @GetMapping("/{accountId}")
    public Optional<AccountSummary> getAccountSummary(@PathVariable Long accountId) {
        return accountSummaryService.getAccountSummary(accountId);
    }

    @GetMapping("/{accountId}/transactions")
    public List<Transaction> getRecentTransactions(@PathVariable Long accountId) {
        return accountSummaryService.getRecentTransactions(accountId);
    }
}
