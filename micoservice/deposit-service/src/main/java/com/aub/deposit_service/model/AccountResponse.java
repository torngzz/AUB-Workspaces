package com.aub.deposit_service.model;

public class AccountResponse {

    private Long id;
    private String accountNumber;
    private String accountHolderName;
    private Double balance;
    private String accouyntType;
    private String status;
    
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
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
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
}
