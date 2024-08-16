package com.aub.account_statement_service.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aub.account_statement_service.TransactionService;
import com.aub.account_statement_service.model.TransactionModel;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<TransactionModel> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionModel> getTransactionById(@PathVariable Long id) {
        TransactionModel transaction = transactionService.getTransactionById(id);
        return transaction != null ? ResponseEntity.ok(transaction) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TransactionModel> createTransaction(
            @RequestParam String accountNumber,
            @RequestParam Double amount,
            @RequestParam String description) {
        try {
            TransactionModel transactionModel = new TransactionModel();
            transactionModel.setAccountNumber(accountNumber);
            transactionModel.setAmount(BigDecimal.valueOf(amount)); // Convert Double to BigDecimal
            transactionModel.setDescription(description);
            TransactionModel createdTransaction = transactionService.saveTransaction(transactionModel);
            return ResponseEntity.ok(createdTransaction);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionModel> updateTransaction(
            @PathVariable Long id,
            @RequestParam String accountNumber,
            @RequestParam Double amount,
            @RequestParam String description) {
        try {
            TransactionModel transactionModel = new TransactionModel();
            transactionModel.setId(id);
            transactionModel.setAccountNumber(accountNumber);
            transactionModel.setAmount(BigDecimal.valueOf(amount)); // Convert Double to BigDecimal
            transactionModel.setDescription(description);
            TransactionModel updatedTransaction = transactionService.updateTransaction(id, transactionModel);
            return updatedTransaction != null ? ResponseEntity.ok(updatedTransaction) : ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        try {
            transactionService.deleteTransaction(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
