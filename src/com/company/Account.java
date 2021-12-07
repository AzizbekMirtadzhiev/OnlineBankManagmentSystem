package com.company;

import java.util.List;

public class Account {
    private int id;
    private String password;
    private double balance;
    private String name;
    private User accounHolder;
    private List <Trancation> trancation;

    public Account(String name, String password ) {
        this.id = id;
        this.balance = balance;
        this.name = name;
        this.accounHolder = accounHolder;
    }
    public void getInfo(){
        System.out.println("Ваше имя: " + getName());
        System.out.println("Ваш счет: " + getBalance());
        System.out.println("Ваш id: " + getId());


    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAccounHolder() {
        return accounHolder;
    }

    public void setAccounHolder(User accounHolder) {
        this.accounHolder = accounHolder;
    }

    public List<Trancation> getTrancation() {
        return trancation;
    }

    public void setTrancation(List<Trancation> trancation) {
        this.trancation = trancation;
    }

    public static void getAllInfo() {
        
    }

    public static void depositUp() {
    }

    public static void withdrawCash() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
