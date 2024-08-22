package com.aub.e_shop.model;

import java.math.BigDecimal;

public class TransferModel {
    private String sourceAccountNumber;  //Sender DebitAccount
    private String destinationAccountNumber; //Receiver CreditAccount
    private BigDecimal amount; //
    
    public TransferModel() {
    }
    public TransferModel(
        String sourceAccountNumber
        , String destinationAccountNumber
        , BigDecimal amount
    ) {
        this.sourceAccountNumber = sourceAccountNumber;
        this.destinationAccountNumber = destinationAccountNumber;
        this.amount = amount;
    }
    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }
    public void setSourceAccountNumber(String sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
    }
    public String getDestinationAccountNumber() {
        return destinationAccountNumber;
    }
    public void setDestinationAccountNumber(String destinationAccountNumber) {
        this.destinationAccountNumber = destinationAccountNumber;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
  
    @Override
    public String toString() {
        return "TransferModel [sourceAccountNumber=" + sourceAccountNumber + ", destinationAccountNumber="
                + destinationAccountNumber + ", amount=" + amount  + "]";
    }
  
 

    
}
