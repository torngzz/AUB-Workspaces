package com.aub.account_summary_service.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Table;


@Table(name = "transactions")
public class TransactionSummary {

    private String transactionType;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
    private String description;

    //Getter Setter
    public String getTransactionType() {
        return transactionType;
    }
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
