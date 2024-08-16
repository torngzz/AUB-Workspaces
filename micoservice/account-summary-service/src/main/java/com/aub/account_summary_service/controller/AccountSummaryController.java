package com.aub.account_summary_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aub.account_summary_service.AccountSummaryService;
import com.aub.account_summary_service.model.AccountSummary;
import com.aub.account_summary_service.model.TransactionSummary;


@RestController
@RequestMapping("/summary")
public class AccountSummaryController {

    @Autowired
    private AccountSummaryService accountSummaryService;

    @GetMapping("/{accountId}")
    public AccountSummary getAccountSummary(@PathVariable Long accountId) {
        return accountSummaryService.getAccountSummary(accountId);
    }

    @GetMapping("/{accountId}/transactions")
    public List<TransactionSummary> getRecentTransactions(@PathVariable Long accountId) {
        return accountSummaryService.getRecentTransactions(accountId);
    }
    
}
