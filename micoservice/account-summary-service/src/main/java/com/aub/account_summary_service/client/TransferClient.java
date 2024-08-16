package com.aub.account_summary_service.client;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aub.account_summary_service.model.TransactionSummary;

public interface TransferClient {
    @GetMapping("/deposits/total/{accountNumber}")
        BigDecimal getTotalDepositsByAccount(@PathVariable String accountNumber);

    @GetMapping("/deposits/{accountNumber}")
        List<TransactionSummary> getDepositsByAccount(@PathVariable String accountNumber);

    @GetMapping("/transfers/source/total/{accountNumber}")
        BigDecimal getTotalWithdrawalsBySourceAccount(@PathVariable String accountNumber);
}
