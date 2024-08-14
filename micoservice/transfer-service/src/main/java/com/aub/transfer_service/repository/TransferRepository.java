package com.aub.transfer_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aub.transfer_service.model.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
    List<Transfer> findBySourceAccountNumber(String sourceAccountNumber);
    List<Transfer> findByDestinationAccountNumber(String destinationAccountNumber);   
}
