package com.company;

import java.util.Date;

public class Trancation {
    private double amount;
    private Date data;
    private Account account;

    public Trancation(double amount, Date date, Account account) {
        this.amount = amount;
        this.data = date;
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public static void trancationHistory() {


    }
}
