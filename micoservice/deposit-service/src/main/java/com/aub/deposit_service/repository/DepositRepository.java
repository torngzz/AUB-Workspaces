package com.aub.deposit_service.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aub.deposit_service.model.Deposit;

public interface DepositRepository extends JpaRepository<Deposit, Long>{

    List<Deposit> findByAccountNumber(String accountNumber);   

    // @Query("SELECT SUM(d.amount) FROM Deposit d WHERE d.accountNumber = ?1")
    // Double getTotalDepositsByAccountNumber(String accountNumber);

    List<Deposit> findByAccountNumberAndAmountGreaterThan(String accountNumber, BigDecimal amount);
}
