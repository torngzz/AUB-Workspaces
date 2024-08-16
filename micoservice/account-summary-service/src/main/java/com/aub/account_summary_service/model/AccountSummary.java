package com.aub.account_summary_service.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Table;

@Table(name = "accounts")
public class AccountSummary {
    private String accountNumber;
    private BigDecimal currentBalance;
    private BigDecimal totalDeposits;
    private BigDecimal totalWithdrawals;
    private List<TransactionSummary> recentTransactions;
    
    //Getter and Setter
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }
    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }
    public BigDecimal getTotalDeposits() {
        return totalDeposits;
    }
    public void setTotalDeposits(BigDecimal totalDeposits) {
        this.totalDeposits = totalDeposits;
    }
    public BigDecimal getTotalWithdrawals() {
        return totalWithdrawals;
    }
    public void setTotalWithdrawals(BigDecimal totalWithdrawals) {
        this.totalWithdrawals = totalWithdrawals;
    }
    public List<TransactionSummary> getRecentTransactions() {
        return recentTransactions;
    }
    public void setRecentTransactions(List<TransactionSummary> recentTransactions) {
        this.recentTransactions = recentTransactions;
    }

}
