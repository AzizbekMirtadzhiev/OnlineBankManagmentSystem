package com.company;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Account implements Serializable {
    private double balance;
    private String valyuta;
    private User accounHolder;
    private int id;
    private List<Trancation> trancation;
    private static final SimpleDateFormat dad = new SimpleDateFormat("dd-MMM-yyyy");

    public Account(int id, double balance, String valyuta, User accounHolder) {
        this.id = id;
        this.balance = balance;

        this.valyuta = valyuta;
        this.accounHolder = accounHolder;
    }

    void getInfo() {
        System.out.println("Баланс : " + this.balance);
        System.out.println("Тип счета : " + this.valyuta);
        System.out.println("Владелец аккаунта : " + getAccounHolder().getFirstName() + " " +
                getAccounHolder().getLastName());
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

    public String getValyuta() {
        return valyuta;
    }

    public void setValyuta(String valyuta) {
        this.valyuta = valyuta;
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
        for (Account a : Main.user.getAccountList()) {
            if (a.getValyuta().equals("kgz")) {
                System.out.println("счет kgz " + a.getBalance());
            } else System.out.println("счет usd " + a.getBalance());

        }
        ;

    }

    public static void depositUp() {
        System.out.println("'Пункт пополнения счета'");
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("1. Чтобы пополнить баланс для kgz счета:");
            System.out.println("2. Чтобы пополнить баланс для usd счета:");

            try {
                int x = scanner.nextInt();
                if (x == 1) {
                    for (Account a : Main.user.getAccountList()) {
                        if (a.getValyuta().equals("kgz")) {
                            addKgzBalance(a);

                        }

                    }

                }
                if (x == 2) {
                    for (Account a : Main.user.getAccountList()) {
                        if (a.getValyuta().equals("usd")) {
                            addUsdBalance(a);

                        }

                    }

                } else {
                    System.out.println("Ошибка!");
                    scanner.next();
                }


            } catch (Exception e) {
                System.out.println("Введите только цифры!");
            }
        }

    }

    private static void addUsdBalance(Account account) {
        account.getInfo();

        while (true) {
            System.out.println("Введите сумму платежа:");

            try {
                Scanner scanner = new Scanner(System.in);

                double platej = scanner.nextDouble();
                double newBalance = account.balance + platej;
                account.setBalance(newBalance);




                Trancation trancation = new Trancation("Пополнение счета", platej, dad.format(new Date()), account);
                trancation.getInfo();
                Main.bank.getTrancations().add(trancation);
                Main.restart();


            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }


    private static void addKgzBalance(Account account) {
        account.getInfo();
        while (true) {
            System.out.println("Введите сумму платежа:");

            try {
                Scanner scanner = new Scanner(System.in);

                double platej = scanner.nextDouble();
                double newBalance = account.balance + platej;
                account.setBalance(newBalance);




                Trancation trancation = new Trancation("Пополнение счета", platej, dad.format(new Date()), account);
                trancation.getInfo();
                Main.bank.getTrancations().add(trancation);
                Main.restart();

            } catch (Exception e) {
                e.printStackTrace();
//                    System.out.println("Введите числа! А не буквы!");
            }


//        Main.Main();
        }
    }

    public static void withdrawCash() {
        System.out.println("'Пункт вывода денег'");
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("1. Чтобы вывести деньги с kgz счета:");
            System.out.println("2. Чтобы вывести деньги с usd счета:");

            try {
                int x = scanner.nextInt();
                if (x == 1) {
                    for (Account a : Main.user.getAccountList()) {
                        if (a.getValyuta().equals("kgz")) {
                            vivodKgz(a);

                        }

                    }

                }
                if (x == 2) {
                    for (Account a : Main.user.getAccountList()) {
                        if (a.getValyuta().equals("usd")) {
                            vivodUsd(a);

                        }

                    }

                } else {
                    System.out.println("Ошибка!");
                    scanner.next();
                }


            } catch (Exception e) {
                System.out.println("Введите только цифры!");
            }
        }
    }

    private static void vivodKgz(Account a) {
        a.getInfo();
        System.out.println("Введите сумму которую хотите вывести: ");

        Scanner scanner = new Scanner(System.in);
        double summ = scanner.nextDouble();
        if (summ > a.getBalance()) {
            System.out.println("Не досаточно суммы на балансе!");
            vivodKgz(a);
        }
        double newBalance = a.getBalance() - summ;
        a.setBalance(newBalance);



        Trancation trancation = new Trancation("Вывод денег", summ, dad.format(new Date()), a);
        trancation.getInfo();
        Main.bank.getTrancations().add(trancation);
        Main.restart();

    }

    private static void vivodUsd(Account a) {
        a.getInfo();
        System.out.println("Введите сумму которую хотите вывести: ");

        Scanner scanner = new Scanner(System.in);
        double summ = scanner.nextDouble();
        if (summ > a.getBalance()) {
            System.out.println("Не досаточно суммы на балансе!");
            vivodUsd(a);
        }
        double newBalance = a.getBalance() - summ;
        a.setBalance(newBalance);



        Trancation trancation = new Trancation("Вывод денег", summ, dad.format(new Date()), a);
        trancation.getInfo();
        Main.bank.getTrancations().add(trancation);
        Main.restart();

    }

    public static void getAllTransaction() {
        boolean b = false;
        while (true) {

            for (Trancation t : Main.bank.getTrancations()) {
                if (Main.user.getFirstName().equals(t.getAccount().getAccounHolder().getFirstName())) {
                    t.getInfo();
                    b = true;
                }


            }
            if (b) {
                break;
            }
            if (b == false) {
                System.out.println("У вас нет истории транзакции!");
                Main.restart();
            }

        }
    }


}


