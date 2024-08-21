package com.aub.transfer_service.model;

import java.math.BigDecimal;

public class AccountResponse {

    private Long id;
    private String accountNumber;
    private String accountHolderName;
    private BigDecimal balance;
    private String accouyntType;
    private String status;
    private String currency;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public String getAccouyntType() {
        return accouyntType;
    }
    public void setAccouyntType(String accouyntType) {
        this.accouyntType = accouyntType;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    } 
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}