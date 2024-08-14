package com.aub.withdrawal_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aub.withdrawal_service.WithdrawalService;
import com.aub.withdrawal_service.model.WithdrawalModel;
import com.aub.withdrawal_service.model.WithdrawalRequestModel;

@RestController
@RequestMapping("/withdrawals")
public class WithdrawalController {

    @Autowired
    private WithdrawalService withdrawalService;

    @PostMapping("/save")
    public ResponseEntity<WithdrawalModel> createWithdrawal(
        @RequestBody WithdrawalRequestModel requestModel
            ) {
        try {
            System.out.println("Account="+requestModel.getAccountNumber());
            System.out.println("Amount="+requestModel.getAmount());
            WithdrawalModel withdrawal = withdrawalService.createWithdrawal(requestModel.getAccountNumber(), requestModel.getAmount());
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