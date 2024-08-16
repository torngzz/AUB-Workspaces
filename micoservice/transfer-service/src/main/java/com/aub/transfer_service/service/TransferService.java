package com.aub.transfer_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aub.transfer_service.client.AccountServiceClient;
import com.aub.transfer_service.model.AccountResponse;
import com.aub.transfer_service.model.Transfer;
import com.aub.transfer_service.repository.TransferRepository;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private AccountServiceClient accountServiceClient;

     public Transfer createTransfer(String sourceAccountNumber, String destinationAccountNumber, Double amount) {

        // Check if the source account number is "0"
        // if ("0".equals(sourceAccountNumber)) {
        //     throw new IllegalArgumentException("Source account number cannot be 0.");
        // }

        // Validate source account
       AccountResponse sourceAccount = accountServiceClient.getAccountByNumber(sourceAccountNumber);
        if (sourceAccount == null || sourceAccount.getStatus().equals("INACTIVE")) {
            throw new RuntimeException("Source account not found or inactive.");
        }
        //Satus: “ACTIVE”,”INACTIVE”
        // Validate destination account
        // AccountServiceClient.AccountResponse destinationAccount = accountServiceClient.getAccountByNumber(destinationAccountNumber);
        AccountResponse destinationAccount = accountServiceClient.getAccountByNumber(destinationAccountNumber);
        if (destinationAccount == null || destinationAccount.getStatus().equals("INACTIVE")) {
            throw new RuntimeException("Destination account not found or inactive.");
        }

        // Check if the source account has sufficient balance
        if (sourceAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance in source account.");
        }

         // Check if the source account balance is less than the destination account balance
        //  if (sourceAccount.getBalance() < destinationAccount.getBalance()) {
        //     throw new IllegalArgumentException("Source account balance is less than destination account balance.");
        // }

        // Proceed with transfer
        Transfer transfer = new Transfer();
        transfer.setSourceAccountNumber(sourceAccountNumber);
        transfer.setDestinationAccountNumber(destinationAccountNumber);
        transfer.setAmount(amount);
        transfer.setTimestamp(LocalDateTime.now());
        transfer.setStatus("COMPLETED");

        // Update balances
        accountServiceClient.decreaseBalance(sourceAccountNumber, amount);
        accountServiceClient.increaseBalance(destinationAccountNumber, amount);

        return transferRepository.save(transfer);
    }

    public List<Transfer> getTransfersBySourceAccountNumber(String sourceAccountNumber) {
        return transferRepository.findBySourceAccountNumber(sourceAccountNumber);
    }

    public List<Transfer> getTransfersByDestinationAccountNumber(String destinationAccountNumber) {
        return transferRepository.findByDestinationAccountNumber(destinationAccountNumber);
    }  
}
