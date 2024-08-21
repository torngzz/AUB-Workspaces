package com.aub.account_summary_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aub.account_summary_service.model.AccountSummary;

@Repository
public interface AccountSummaryRepository extends JpaRepository<AccountSummary, Long>{

}
