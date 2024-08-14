package com.aub.deposit_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aub.deposit_service.model.Deposit;

public interface DepositRepository extends JpaRepository<Deposit, Long>{

    List<Deposit> findByAccountNumber(String accountNumber);   
}
