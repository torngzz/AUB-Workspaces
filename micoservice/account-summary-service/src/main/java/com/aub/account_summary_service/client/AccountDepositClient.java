package com.aub.account_summary_service.client;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aub.account_summary_service.model.TransactionSummary;

public interface AccountDepositClient {
    @GetMapping("/deposits/{accountNumber}")
    List<TransactionSummary> getDepositsByAccount(@PathVariable("accountNumber") String accountNumber);

    @GetMapping("/deposits/total/{accountNumber}")
    BigDecimal getTotalDepositsByAccount(@PathVariable("accountNumber") String accountNumber);
    
}

