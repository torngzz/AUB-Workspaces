package com.aub.account_summary_service.client;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


public interface WithdrawalClient {
    // @GetMapping("/withdrawals/{accountNumber}")
    // List<TransactionSummary> getWithdrawalsByAccount(@PathVariable("accountNumber") String accountNumber);

    @GetMapping("/withdrawals/total/{accountNumber}")
    BigDecimal getTotalWithdrawalsByAccount(@PathVariable("accountNumber") String accountNumber);
}
