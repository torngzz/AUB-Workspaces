package com.aub.withdrawal_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aub.withdrawal_service.WithdrawalService;
import com.aub.withdrawal_service.model.WithdrawalModel;

@RestController
@RequestMapping("/withdrawals")
public class WithdrawalController {

    @Autowired
    private WithdrawalService withdrawalService;

    @PostMapping("/save")
    public ResponseEntity<WithdrawalModel> createWithdrawal(
            @RequestParam String accountNumber,
            @RequestParam Double amount) {
        try {
            WithdrawalModel withdrawal = withdrawalService.createWithdrawal(accountNumber, amount);
            return ResponseEntity.ok(withdrawal);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<List<WithdrawalModel>> getWithdrawalsByAccountNumber(@PathVariable String accountNumber) {
        List<WithdrawalModel> withdrawals = withdrawalService.getWithdrawalsByAccountNumber(accountNumber);
        return ResponseEntity.ok(withdrawals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WithdrawalModel> getWithdrawalById(@PathVariable Long id) {
        WithdrawalModel withdrawal = withdrawalService.getWithdrawalById(id);
        return withdrawal != null ? ResponseEntity.ok(withdrawal) : ResponseEntity.notFound().build();
    }
}