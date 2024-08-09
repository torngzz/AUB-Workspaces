package com.aub.account_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aub.account_service.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
    
    Account findByAccountNumber(String accountNumber);
    
}
