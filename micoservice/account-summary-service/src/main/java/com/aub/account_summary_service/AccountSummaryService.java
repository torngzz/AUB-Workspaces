package com.aub.account_summary_service;

import java.math.BigDecimal;
import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.aub.account_summary_service.client.AccountServiceClient;
import com.aub.account_summary_service.client.TransferClient;
import com.aub.account_summary_service.client.WithdrawalClient;
import com.aub.account_summary_service.model.AccountSummary;
import com.aub.account_summary_service.model.TransactionSummary;

@Service
public class AccountSummaryService {
     @Autowired
    private AccountServiceClient accountServiceClient;

    @Autowired
    private TransferClient transferClient;

    @Autowired
    private WithdrawalClient withdrawalClient;

    public AccountSummary getAccountSummary(Long accountId) {
        AccountSummary accountSummary = accountServiceClient.getAccountSummary(accountId);
        String accountNumber = accountSummary.getAccountNumber();

        BigDecimal totalDeposits = transferClient.getTotalDepositsByAccount(accountNumber);
        BigDecimal totalWithdrawals = withdrawalClient.getTotalWithdrawalsByAccount(accountNumber);

        accountSummary.setTotalDeposits(totalDeposits);
        accountSummary.setTotalWithdrawals(totalWithdrawals);

        List<TransactionSummary> recentTransactions = accountServiceClient.getRecentTransactions(accountId);
        accountSummary.setRecentTransactions(recentTransactions);

        return accountSummary;
    }

    public List<TransactionSummary> getRecentTransactions(Long accountId) {
        return accountServiceClient.getRecentTransactions(accountId);
    }
}
