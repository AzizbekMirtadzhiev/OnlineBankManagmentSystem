package com.company;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Bank implements Serializable {


    private String bankName;
    private List<User> castomers;
    private List<Account> accounts;
    private List<Trancation> trancations;

    public List<Trancation> getTrancations() {
        return trancations;
    }

    public void setTrancations(List<Trancation> trancations) {
        this.trancations = trancations;
    }

    static final SimpleDateFormat dad = new SimpleDateFormat("dd-MMM-yyyy");


    public Bank(String bankName, List<User> castomers, List<Account> accounts,List<Trancation> trancations) {
        this.bankName = bankName;
        this.castomers = castomers;
        this.accounts = accounts;
        this.trancations = trancations;
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
        System.out.println("Вывод денег");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 1 если хотите перевести деньги с kgz");
        System.out.println("Введите 2 если хотите перевести деньги с usd");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a == 1) {
            translateKgz(Main.user.getAccountList().get(0));
        }
        if (b == 2) {
            translateUsd(Main.user.getAccountList().get(1));
        } else System.out.println("Введите то что имеется!");
        transferMoney();


    }


    private static void translateKgz(Account account) {
        System.out.println("Введите id того кому хотите перевести деньги:");
        Scanner scanner = new Scanner(System.in);
        int dlyaId = scanner.nextInt();
        for (Account a : Main.bank.getAccounts()) {
            if (dlyaId == a.getId()) {
                System.out.println("Введите сколько хотите отправить денег");
                double summ = scanner.nextDouble();
                if (a.getValyuta().equals("usd")) {
                    tUsd(summ, account, a);
                }

                if (account.getBalance() < summ && summ > 0) {
                    System.out.println("У вас не достаточно денег или введите больше нулья!");
                    Main.restart();

                } else {
                    double newBalance = account.getBalance() - summ;
                    account.setBalance(newBalance);

                    Trancation trancation = new Trancation("Перевод денег (отправлено)", summ, dad.format(new Date()),
                            account);
                    double dd = a.getBalance() + summ;
                    a.setBalance(dd);
                    Trancation trancation2 = new Trancation("Перевод денег (принято)", summ, dad.format(new Date()),
                            a);
                    Main.trancationsList.add(trancation);
                    Main.trancationsList.add(trancation2);
                    trancation.getInfo();
                    trancation2.getInfo();
                    Main.restart();


                }

            }

        }

    }

    private static void tUsd(double summ, Account account, Account a) {
        summ = summ / Main.courseDollar;
        Math.round(summ);
        double newBalance = account.getBalance() - summ;
        account.setBalance(newBalance);
        Trancation trancation = new Trancation("Перевод денег (отправлено)", summ, dad.format(new Date()), account);
        double dd = a.getBalance() + summ;
        a.setBalance(dd);
        Trancation trancation2 = new Trancation("Перевод денег (принято)", summ, dad.format(new Date()), a);
        Main.trancationsList.add(trancation);
        Main.trancationsList.add(trancation2);
        trancation.getInfo();
        trancation2.getInfo();
        Main.restart();
        if (account.getBalance() < summ) {
            System.out.println("Не достаточно средств!");
            Main.restart();
        }
    }

    private static void tKgz(double summ, Account account, Account a) {
        summ = summ * Main.courseDollar;
        double newBalance = account.getBalance() - summ;
        account.setBalance(newBalance);
        Trancation trancation = new Trancation("Перевод денег (отправлено)", summ, dad.format(new Date()), account);
        double dd = a.getBalance() + summ;
        a.setBalance(dd);
        Trancation trancation2 = new Trancation("Перевод денег (принято)", summ, dad.format(new Date()), a);
        Main.trancationsList.add(trancation);
        Main.trancationsList.add(trancation2);
        trancation.getInfo();
        trancation2.getInfo();
        Main.restart();
        if (account.getBalance() < summ) {
            System.out.println("Не достаточно средств!");
            Main.restart();
        }
    }

    private static void translateUsd(Account account) {

        System.out.println("Введите id того кому хотите перевести деньги:");
        Scanner scanner = new Scanner(System.in);
        int dlyaId = scanner.nextInt();
        for (Account a : Main.bank.getAccounts()) {
            if (dlyaId == a.getId()) {
                System.out.println("Введите сколько хотите отправить денег");
                double summ = scanner.nextDouble();
                if (a.getValyuta().equals("kgz")) {

                    tKgz(summ, account, a);
                }

                    else if (account.getBalance() < summ && summ > 0) {
                    System.out.println("У вас не достаточно денег или введите больше нулья!");
                    Main.restart();
                } else {
                    double newBalance = account.getBalance() - summ;
                    account.setBalance(newBalance);

                    Trancation trancation = new Trancation("Перевод денег (отправлено)", summ, dad.format(new Date()),
                            account);
                    double dd = a.getBalance() + summ;
                    a.setBalance(dd);
                    Trancation trancation2 = new Trancation("Перевод денег (принято)", summ, dad.format(new Date()),
                            a);
                    Main.trancationsList.add(trancation);
                    System.out.println("----------------------------------");
                    Main.trancationsList.add(trancation2);
                    trancation.getInfo();
                    trancation2.getInfo();
                    Main.restart();


                }

            }

        }

    }
}
