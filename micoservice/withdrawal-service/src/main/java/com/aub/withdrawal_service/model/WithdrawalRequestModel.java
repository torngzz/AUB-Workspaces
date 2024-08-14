package com.aub.withdrawal_service.model;

public class WithdrawalRequestModel {
    private String accountNumber;
    private Double amount;

    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
}
