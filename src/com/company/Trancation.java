package com.company;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Trancation implements Serializable {
    private double amount;
    private String data;
    private Account account;
    private String typeTrancation;


    public Trancation(String typeTrancation, double amount, String date, Account account) {
        this.amount = amount;
        this.data = date;
        this.account = account;
        this.typeTrancation = typeTrancation;
    }
        void getInfo(){
            System.out.println("Тип транзакции: " + this.typeTrancation);
            System.out.println("Тип счета: " + getAccount().getValyuta());
            System.out.println("Cумма транзакции: " + this.amount);
            System.out.println("Дата транзакции: " + this.data);
            System.out.println("Бааланс после транзакции : " + getAccount().getBalance());
            System.out.println("Владелец транзакции : " + getAccount().getAccounHolder().getFirstName() + " " +
                    getAccount().getAccounHolder().getLastName());
            System.out.println("**************************************************************************************");
        }

    public String getTypeTrancation() {
        return typeTrancation;
    }

    public void setTypeTrancation(String typeTrancation) {
        this.typeTrancation = typeTrancation;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
