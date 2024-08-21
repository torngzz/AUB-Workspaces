package com.aub.account_summary_service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aub.account_summary_service.model.AccountSummary;
import com.aub.account_summary_service.model.TransactionSummary;


@FeignClient(name = "account-service")

public interface AccountServiceClient {
    @GetMapping("/accounts/{accountId}")
    AccountSummary getAccountSummary(@PathVariable("accountId") Long accountId);

    @GetMapping("/accounts/{accountId}/transactions")
    List<TransactionSummary> getRecentTransactions(@PathVariable("accountId") Long accountId);
}
