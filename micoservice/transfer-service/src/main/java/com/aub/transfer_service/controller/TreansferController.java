package com.aub.transfer_service.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aub.transfer_service.model.Transfer;
import com.aub.transfer_service.service.TransferService;

@RestController
@RequestMapping("/transfer")
public class TreansferController {

    @Autowired
    private TransferService transferService;

    // @PostMapping
    // public ResponseEntity<Transfer> createTransfer(
    //         @RequestParam String sourceAccountNumber, 
    //         @RequestParam String destinationAccountNumber, 
    //         @RequestParam BigDecimal amount) {
    //     Transfer transfer = transferService.createTransfer(sourceAccountNumber, destinationAccountNumber, amount);
    //     return new ResponseEntity<>(transfer, HttpStatus.CREATED);
    // } 



    // @PostMapping
    // public ResponseEntity<Transfer> createTransfer(
    //         @RequestParam String sourceAccountNumber, 
    //         @RequestParam String destinationAccountNumber, 
    //         @RequestParam Double amount) {
    //     try {
    //         Transfer transfer = transferService.createTransfer(sourceAccountNumber, destinationAccountNumber, amount);
    //         return new ResponseEntity<>(transfer, HttpStatus.CREATED);
    //     } catch (IllegalArgumentException e) {
    //         return ResponseEntity.badRequest().body(null); // You can customize this response as needed
    //     } catch (RuntimeException e) {
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Customize as needed
    //     }
    // }

    // @PostMapping
    // public ResponseEntity<?> createTransfer(
    //         @RequestParam String sourceAccountNumber, 
    //         @RequestParam String destinationAccountNumber, 
    //         @RequestParam BigDecimal amount) {

    //     try {
    //         // Attempt to create the transfer
    //         Transfer transfer = transferService.createTransfer(sourceAccountNumber, destinationAccountNumber, amount);

    //         // Return the transfer if successful
    //         return new ResponseEntity<>(transfer, HttpStatus.CREATED);

    //     } catch (RuntimeException ex) {
    //         // Handle any runtime exceptions (e.g., validation errors, insufficient funds)
    //         return ResponseEntity
    //                 .status(HttpStatus.BAD_REQUEST)
    //                 .body("Error: " + ex.getMessage());
    //     } catch (Exception ex) {
    //         // Handle any unexpected exceptions
    //         return ResponseEntity
    //                 .status(HttpStatus.INTERNAL_SERVER_ERROR)
    //                 .body("An unexpected error occurred: " + ex.getMessage());
    //     }
    // }

    @PostMapping
    public ResponseEntity<?> createTransfer(@RequestBody Transfer transferRequest) {

        try {
            // Extract details from the request body
            String sourceAccountNumber = transferRequest.getSourceAccountNumber();
            String destinationAccountNumber = transferRequest.getDestinationAccountNumber();
            BigDecimal amount = transferRequest.getAmount();

            // Attempt to create the transfer
            Transfer transfer = transferService.createTransfer(sourceAccountNumber, destinationAccountNumber, amount);

            // Return the transfer if successful
            return new ResponseEntity<>(transfer, HttpStatus.CREATED);

        } catch (RuntimeException ex) {
            // Handle any runtime exceptions (e.g., validation errors, insufficient funds)
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error: " + ex.getMessage());
        } catch (Exception ex) {
            // Handle any unexpected exceptions
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + ex.getMessage());
        }
    }


    @GetMapping("/source/{sourceAccountNumber}")
    public ResponseEntity<List<Transfer>> getTransfersBySourceAccountNumber(@PathVariable String sourceAccountNumber) {
        List<Transfer> transfers = transferService.getTransfersBySourceAccountNumber(sourceAccountNumber);
        return ResponseEntity.ok(transfers);
    }

    @GetMapping("/destination/{destinationAccountNumber}")
    public ResponseEntity<List<Transfer>> getTransfersByDestinationAccountNumber(@PathVariable String destinationAccountNumber) {
        List<Transfer> transfers = transferService.getTransfersByDestinationAccountNumber(destinationAccountNumber);
        return ResponseEntity.ok(transfers);
    }

    // @GetMapping("/total/source/{sourceAccountNumber}")
    // public ResponseEntity<Double> getTotalAmountBySourceAccountNumber(@PathVariable String sourceAccountNumber) {
    //     Double totalAmount = transferService.getTotalAmountBySourceAccountNumber(sourceAccountNumber);
    //     return ResponseEntity.ok(totalAmount);
    // }

    // @GetMapping("/total/destination/{destinationAccountNumber}")
    // public ResponseEntity<Double> getTotalAmountByDestinationAccountNumber(@PathVariable String destinationAccountNumber) {
    //     Double totalAmount = transferService.getTotalAmountByDestinationAccountNumber(destinationAccountNumber);
    //     return ResponseEntity.ok(totalAmount);
    // }

    @GetMapping("/total/{accountNumber}")
    public ResponseEntity<BigDecimal> getTotalTransferByAccount(@PathVariable String accountNumber) {
        BigDecimal totalTransfers = transferService.getTotalTransfersByAccount(accountNumber);
        return ResponseEntity.ok(totalTransfers);
    }
}
