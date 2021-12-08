package com.company;

import java.util.List;

public class Bank {
    private String bankName;
    private List <User> castomers;
    private List<Account> accounts;

    public Bank(String bankName, List<User> castomers, List<Account> accounts) {
        this.bankName = bankName;
        this.castomers = castomers;
        this.accounts = accounts;
    }

    public String getBankName() {
        return bankName;
    }

    public List<User> getCastomers() {
        return castomers;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setCastomers(List<User> castomers) {
        this.castomers = castomers;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public static void transferMoney() {

    }
}
