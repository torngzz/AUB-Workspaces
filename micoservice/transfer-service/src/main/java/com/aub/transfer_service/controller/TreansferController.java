package com.aub.transfer_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public ResponseEntity<Transfer> createTransfer(
            @RequestParam String sourceAccountNumber, 
            @RequestParam String destinationAccountNumber, 
            @RequestParam Double amount) {
        Transfer transfer = transferService.createTransfer(sourceAccountNumber, destinationAccountNumber, amount);
        return new ResponseEntity<>(transfer, HttpStatus.CREATED);
    } 
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

    
}
