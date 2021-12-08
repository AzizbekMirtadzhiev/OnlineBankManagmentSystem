package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static Bank bank;
    public static User user;

    public static void main(String[] args) {


        List<User> userList = new ArrayList<>();

        User danil = new User("Данил", "Данилов", "danil", "danil123");
        userList.add(new User("Данил", "Данилов", "danil", "danil123"));
        userList.add(new User("Саша", "Сашиев", "sasha", "sasha123"));
        userList.add(new User("Светлана", "Андреева", "sveta", "sveta123"));
        userList.add(new User("Юсуф", "Салижанов", "yusuf", "yusuf123"));

        List<Account> accountList = new ArrayList<>();

        Account danilKgz = new Account("kgz", danil);
        Account danilUsd = new Account("usd", danil);
        List<Account> danilAccountList = new ArrayList<>();
        danilAccountList.add(danilKgz);
        danilAccountList.add(danilUsd);
        danil.setAccontList(danilAccountList);

        accountList.add(danilKgz);
        accountList.add(danilUsd);
        userList.add(danil);

//        accountList.add(new Account("kgz", userList.get(0)));
//        accountList.add(new Account("usd", userList.get(0)));
        accountList.add(new Account("kgz", userList.get(1)));
        accountList.add(new Account("usd", userList.get(1)));
        accountList.add(new Account("kgz", userList.get(2)));
        accountList.add(new Account("usd", userList.get(2)));
        accountList.add(new Account("kgz", userList.get(3)));
        accountList.add(new Account("usd", userList.get(3)));

        bank = new Bank("Demir",userList, accountList);
        user = new User();

        User.privetstviye();
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
                        Trancation.trancationHistory();

                        break;
                }


            } catch (Exception e) {
                System.out.println("Ошибка! Повторите попытку!");
            }
        }

    }
//    private static void login(List <User> userlog) {
//        Scanner scanner = new Scanner(System.in);
//        int count = 0;
//        while (true){
//            try {
//                System.out.println( "Введите ваш логин: ");
//                String dlyaLogin = scanner.nextLine();
//                System.out.println("Введите ваш пароль: ");
//                String dlyaPassword = scanner.nextLine();
//                while (true){
//                    for (User r: userlog.get()) {
//                        if(r.getLogin().equals(dlyaLogin) && r.getPassword().equals(dlyaPassword)){
//                            System.out.println("Здравствуйте, " + r.getName() + "! ");
//                            System.out.println("-----------------------------------");
//                            loggedReader = r;
//                            mainMenu();
//                        }
//
//                    }
//                    if (count < 2){
//                        count++;
//                        System.out.println("Неправильный логин или пароль! У вас осталось " + (3 -count) + " попыток");
//                        System.out.println("Введите ваш логин:");
//                        dlyaLogin = scanner.nextLine();
//                        System.out.println("Введите ваш пароль:");
//                        dlyaPassword = scanner.nextLine();
//                    } else {
//                        System.out.println("Не верно введенные данные: 3 раза. Система закрывается");
//                        System.exit(0);
//                    }
//                }
//
//            }catch (Exception e ){
//                System.out.println("Неправильный формат ввода!");
//            }
//        }


    }


