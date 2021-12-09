package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static Bank bank;
    public static User user;
    static   List <User> users = new ArrayList<>();
    static List<Trancation> trancationsList = new ArrayList<>();
    static double courseDollar = 86;

    public static void main(String[] args) {
        List <Account> accaountt = new ArrayList<>();



        List<Account> danilAccountList = new ArrayList<>();
        User danil = new User("Данил", "Данилов", "14", "1",danilAccountList );
        Account danilKgz = new Account(11,5000,"kgz", danil );
        Account danilUsd = new Account(22,5000,"usd", danil);
        danilAccountList.add(danilKgz);
        danilAccountList.add(danilUsd);
        accaountt.addAll(danilAccountList);
        users.add(danil);

        List<Account> sashaAccountList = new ArrayList<>();
        User sasha = new User("Саша", "Сашиев", "1", "1", sashaAccountList);
        Account sashaKgz = new Account(33,13000,"kgz", sasha);
        Account sashaUsd = new Account(44,15000,"usd", sasha);
        sashaAccountList.add(sashaKgz);
        sashaAccountList.add(sashaUsd);
        accaountt.addAll(sashaAccountList);
        users.add(sasha);

        List<Account> ivanAccountList = new ArrayList<>();
        User ivan = new User("Иван", "Иванов", "3", "3",ivanAccountList );
        Account ivanKgz = new Account(66,37000,"kgz", ivan);
        Account ivanUsd = new Account(77,35000,"usd", ivan);
        ivanAccountList.add(ivanKgz);
        ivanAccountList.add(ivanUsd);
        accaountt.addAll(ivanAccountList);
        users.add(ivan);







        bank = new Bank("Demir",users, accaountt, trancationsList);


        readingFile();
        User.voyti();
//        Main();



           }


    static void Main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите из следующих пунктов: ...");

        while (true) {
            System.out.println("1. Информация об аккаунте");
            System.out.println("2. Пополнить счет");
            System.out.println("3. Вывести деньги");
            System.out.println("4. Отправить деньги");
            System.out.println("5. История действий");
            System.out.println("6. Сохранить и выйти");
            try {
                int deystviye = scanner.nextInt();
                switch (deystviye) {
                    case 1:
                        Account.getAllInfo();
                        break;
                    case 2:
                        Account.depositUp();
                        break;
                    case 3:
                        Account.withdrawCash();
                        break;
                    case 4:
                        Bank.transferMoney();
                        break;
                    case 5:
                        Account.getAllTransaction();
                        break;
                    case 6:
                        savingData();


                }


            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Ошибка! Повторите попытку!");
            }
        }

    }

    static void restart() {
        boolean d = false;
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-Нажмите любое число чтобы перейти в гланое меню:-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-Нажмите 0 чтобы завершит процесс и сохранит изминение:-*-*-*-*-*-*-*-*-*-*-*-");
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                int b = scanner.nextInt();
                if (b == 0) {
                    savingData();

                }
                d = true;
                Main();
                break;


            } catch (Exception e) {
                System.err.println("\n-*-*-*-*-*-*-*-*-*-*-*-Нажмите любое ЧИСЛО чтобы перейти в гланое меню!!!-*-*-*-*-*-*-*-*-*-*-*-");
            }
            if (d) {
                break;
            }
        }
    }


    private static void savingData() {
        try {
            ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("Bank"));
            ois.writeObject(bank);
            ois.close();
            System.exit(0);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Запись не удалась");

        }


    }

    private static void readingFile() {
        try {
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Bank"));
            bank = (Bank) oos.readObject();
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Не удалось прочитать файл!!!");
        }

    }

    }


