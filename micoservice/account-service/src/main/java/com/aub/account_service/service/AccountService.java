package com.aub.account_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aub.account_service.model.Account;
import com.aub.account_service.repository.AccountRepository;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

   
    /**
     * 
     * @param account
     * @return
     * @throws Exception
     */
     public Account createAccount(Account account) throws Exception {
        //Validation data
        // Valid account it must be only 6 digit

        if (!account.getAccountNumber().matches("\\d{6}")) {
            throw new Exception("Account number must be exactly 6 digits");
        }

        // Check if the account number already exists
        if (accountRepository.findByAccountNumber(account.getAccountNumber()) != null) {
            throw new Exception("Account with number " + account.getAccountNumber() + " already exists");
        }
        return accountRepository.save(account);
    }

    /**
     * 
     * @param id
     * @return
     */
    public Account getAccountById(Long id){
        return accountRepository.findById(id).orElse(null);
    }

    /**
     * 
     * @param accountNumber
     * @return
     */
    public Account getAccountByNumber(String accountNumber){
        return accountRepository.findByAccountNumber(accountNumber);
    }

    /**
     * 
     * @return
     */
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    /**
     * 
     * @param account
     * @return
     */
    public Account updateAccount(Account account){
        return accountRepository.save(account);
    }
    /**
     * 
     * @param id
     */
    public void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }

    public Account updateBalance(String accountNumber, Double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new RuntimeException("Account not found");
        }
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }
    
}
