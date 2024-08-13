package com.aub.withdrawal_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aub.withdrawal_service.model.WithdrawalModel;

@Repository
public interface WithdrawalRepository extends JpaRepository<WithdrawalModel, Long>{
    List<WithdrawalModel> findByAccountNumber(String accountNumber);
}
