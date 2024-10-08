package com.aub.withdrawal_service.model;

public class AccountResponse {
        private Long id;
        private String accountNumber;
        private String accountHolderName;
        private Double balance;
        private String accouyntType;
        private String status;
        private String currency;
    

    public Long getId() {
            return id;
        }


        public void setId(Long id) {
            this.id = id;
        }


        public String getAccountNumber() {
            return accountNumber;
        }


        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }


        public String getAccountHolderName() {
            return accountHolderName;
        }


        public void setAccountHolderName(String accountHolderName) {
            this.accountHolderName = accountHolderName;
        }


        public Double getBalance() {
            return balance;
        }


        public void setBalance(Double balance) {
            this.balance = balance;
        }


        public String getAccouyntType() {
            return accouyntType;
        }


        public void setAccouyntType(String accouyntType) {
            this.accouyntType = accouyntType;
        }


        public String getStatus() {
            return status;
        }


        public void setStatus(String status) {
            this.status = status;
        }


        public String getCurrency() {
            return currency;
        }
        public void setCurrency(String currency) {
            this.currency = currency;
        }
        @Override
        public String toString() {
            return "Account [id=" + id + ", accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName
                    + ", balance=" + balance + ", accouyntType=" + accouyntType + ", status=" + status + ", currency="
                    + currency + "]";
        }
    
}
