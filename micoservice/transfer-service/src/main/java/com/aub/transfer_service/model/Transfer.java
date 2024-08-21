package com.aub.transfer_service.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="TBL_TRANSFER")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceAccountNumber;  //Sender DebitAccount
    private String destinationAccountNumber; //Receiver CreditAccount
    private BigDecimal amount; //
    private LocalDateTime timestamp;
    private String status;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "Transfer [id=" + id + ", sourceAccountNumber=" + sourceAccountNumber + ", destinationAccountNumber="
                + destinationAccountNumber + ", amount=" + amount + ", timestamp=" + timestamp + ", status=" + status
                + "]";
    }  
}
