package com.aub.transfer_service.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aub.transfer_service.client.AccountServiceClient;
import com.aub.transfer_service.model.AccountResponse;
import com.aub.transfer_service.model.Transfer;
import com.aub.transfer_service.repository.TransferRepository;

import feign.FeignException;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private AccountServiceClient accountServiceClient;

    public Transfer createTransfer(String sourceAccountNumber, String destinationAccountNumber, BigDecimal amount) {

            try {
            // Validate source account
            AccountResponse sourceAccount = accountServiceClient.getAccountByNumber(sourceAccountNumber);
            if (sourceAccount == null || sourceAccount.getStatus().equals("INACTIVE")) {
                throw new RuntimeException("Source account '" + sourceAccountNumber + "' not found or inactive.");
            }

            // Validate destination account
            AccountResponse destinationAccount = accountServiceClient.getAccountByNumber(destinationAccountNumber);
            if (destinationAccount == null || destinationAccount.getStatus().equals("INACTIVE")) {
                throw new RuntimeException("Destination account '" + destinationAccountNumber + "' not found or inactive.");
            }

            // Check if the source account has sufficient balance
            BigDecimal sourceBalance = sourceAccount.getBalance();
            if (sourceBalance.compareTo(amount) < 0) {
                throw new RuntimeException("Insufficient balance in source account '" + sourceAccountNumber + "'.");
            }

            // Validate that the source and destination account currencies are the same
            String sourceCurrency = sourceAccount.getCurrency();
            String destinationCurrency = destinationAccount.getCurrency();
            if (!sourceCurrency.equals(destinationCurrency)) {
                throw new RuntimeException("Currency mismatch: Source account is in " + sourceCurrency + ", destination account is in " + destinationCurrency + ".");
            }

            // Check if the source and destination account numbers are the same
            if (sourceAccountNumber.equals(destinationAccountNumber)) {
                throw new RuntimeException("Transfer cannot be made to the same account. Source and destination account numbers must be different.");
            }

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

            // Save and return the transfer
            return transferRepository.save(transfer);

        } catch (FeignException.NotFound e) {
            // Handle 404 Not Found error from account service
            throw new RuntimeException("Account not found: " + e.getMessage());
        } catch (FeignException e) {
            // Handle other errors from account service
            throw new RuntimeException("Error communicating with account service: " + e.getMessage());
        }
    }


    public List<Transfer> getTransfersBySourceAccountNumber(String sourceAccountNumber) {
        return transferRepository.findBySourceAccountNumber(sourceAccountNumber);
    }

    public List<Transfer> getTransfersByDestinationAccountNumber(String destinationAccountNumber) {
        return transferRepository.findByDestinationAccountNumber(destinationAccountNumber);
    }  

    // public Double getTotalAmountBySourceAccountNumber(String sourceAccountNumber) {
    //     List<Transfer> transfers = transferRepository.findBySourceAccountNumber(sourceAccountNumber);
    //     return transfers.stream()
    //             .mapToDouble(Transfer::getAmount)
    //             .sum();
    // }

    // public Double getTotalAmountByDestinationAccountNumber(String destinationAccountNumber) {
    //     List<Transfer> transfers = transferRepository.findByDestinationAccountNumber(destinationAccountNumber);
    //     return transfers.stream()
    //             .mapToDouble(Transfer::getAmount)
    //             .sum();
    // }

    public BigDecimal getTotalTransfersByAccount(String accountNumber) {
        List<Transfer> outgoingTransfers = transferRepository.findBySourceAccountNumber(accountNumber);
        BigDecimal totalOutgoing = outgoingTransfers.stream()
                .map(Transfer::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add); 

        
        List<Transfer> incomingTransfers = transferRepository.findByDestinationAccountNumber(accountNumber);

        BigDecimal totalIncome = incomingTransfers.stream()
                .map(Transfer::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

                return totalIncome.subtract(totalOutgoing);      
    }
}
