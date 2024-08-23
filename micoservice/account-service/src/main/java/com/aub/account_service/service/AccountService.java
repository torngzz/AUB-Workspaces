package com.aub.account_service.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aub.account_service.model.Account;
import com.aub.account_service.repository.AccountRepository;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    // private static final String CCY[] = {"KHR","USD"};
    private static final String[] ALLOWED_CURRENCIES = {"KHR", "USD"};

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

         // Validate currency (must be KHR or USD)
         boolean validCurrency = false;
         for (String currency : ALLOWED_CURRENCIES) {
             if (currency.equals(account.getCurrency())) {
                 validCurrency = true;
                 break;
             }
         }
 
         if (!validCurrency) {
             throw new Exception("Invalid currency. Only 'KHR' or 'USD' are allowed.");
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
    // public Account getAccountById(Long id){
    //     return accountRepository.findById(id).orElse(
    //         null);
    // }
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Account with ID " + id + " not found.")
        );
    }

    /**
     * 
     * @param accountNumber
     * @return
     */
    // public Account getAccountByNumber(String accountNumber){
    //     return accountRepository.findByAccountNumber(accountNumber);
    // }
    public Account getAccountByNumber(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new RuntimeException("Account with account number " + accountNumber + " not found.");
        }
        return account;
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
    // public Account updateAccount(Account account){
    //     return accountRepository.save(account);
    // }

    public Account updateAccount(Account account) {
        // Check if the account exists
        Account existingAccount = accountRepository.findByAccountNumber(account.getAccountNumber());
        if (existingAccount == null) {
            throw new RuntimeException("Cannot update. Account with account number " + account.getAccountNumber() + " not found.");
        }
    
        // Validate that the account number is exactly 6 digits
        if (!account.getAccountNumber().matches("\\d{6}")) {
            throw new RuntimeException("Invalid account number. It must be exactly 6 digits.");
        }
    
        // Validate that the currency is allowed (either "KHR" or "USD")
        String currency = account.getCurrency();
        if (!Arrays.asList(ALLOWED_CURRENCIES).contains(currency)) {
            throw new RuntimeException("Invalid currency. Only 'KHR' or 'USD' are allowed.");
        }
    
        // If all validations pass, proceed with updating the account
        return accountRepository.save(account);
    }
    /**
     * 
     * @param id
     */
    // public void deleteAccount(Long id){
    //     accountRepository.deleteById(id);
    // }

    public String deleteAccount(Long id) {
        // Check if the account exists by id
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account with ID " + id + " not found."));
    
        // If account exists, delete it
        accountRepository.deleteById(id);
    
        // Return success message
        return "Account with ID " + id + " has been successfully deleted.";
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
