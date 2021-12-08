package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Account {
    private double balance;
    private String valyuta;
    private User accounHolder;
    private List<Trancation> trancation;

    public Account(String valyuta, User accounHolder) {

        this.valyuta = valyuta;
        this.accounHolder = accounHolder;
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
        for (Account a : Main.user.getAccontList()) {
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

            System.out.println("1. Чтобы пополнить баланс для kgz валюты:");
            System.out.println("2. Чтобы пополнить баланс для usd валюты:");

            try {


                int x = scanner.nextInt();
                if (x < 3 && x > 0) {
                    switch (x) {
                        case 1:
                            addKgzBalance();
                            break;
                        case 2:
                            addUsdBalance();
                            break;

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

    private static void addUsdBalance() {
        while (true) {
            Scanner scanner = new Scanner(System.in);

//        System.out.println("Введите ваш id:");
//        String id = scanner.nextLine();
//        System.out.println("Введите ваш пароль:");
//        String password = scanner.nextLine();
            for (User u : Main.bank.getCastomers()) {
                System.out.println("Введите сумму платежа:");
                try {

                    double platej = scanner.nextInt();
                    System.out.println();
//                    u.getAccontList().get(0).getBalance() =  u.getAccontList().get(1).getBalance() += platej;

                } catch (Exception e) {
                    System.out.println("Введите числа! А не буквы!");
                }


            }

        }
//        Main.Main();
    }


    private static void addKgzBalance() {
        while (true) {
            System.out.println("Введите сумму платежа:");

            Scanner scanner = new Scanner(System.in);

                try {
                    double platej = scanner.nextDouble();
                    double oldBalance = Main.user.getAccontList().get(0).getBalance();
                    double newBalance = oldBalance + platej;
                    Main.user.getAccontList().get(0).setBalance(newBalance);


                    List <Trancation> trancationsList = new ArrayList<>();
                    Trancation trancation = new Trancation(platej, new Date(), Main.user.getAccontList().get(0));
                    trancationsList.add(trancation);
                    Main.user.getAccontList().get(0).setTrancation(trancationsList);



                } catch (Exception e) {
                    e.printStackTrace();
//                    System.out.println("Введите числа! А не буквы!");
                }




//        Main.Main();
        }
    }

        public static void withdrawCash () {
            System.out.println("Введите сколько хотите вывести деньги:");
            try {
                for (User u : Main.bank.getCastomers()) {

                    System.out.println("Ваш Киргизский счет: ");
                    u.getAccontList().get(0).getBalance();
//            System.out.println("Ваш Долларовый счет: " + u.getAccontList().get(1).getBalance());
                }


                Scanner scanner = new Scanner(System.in);
                double vivod = scanner.nextDouble();


            } catch (Exception e) {
                System.out.println("Введите цифру! А не буквы!");
            }

        }

    }

