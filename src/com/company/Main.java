package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static User user;

    public static void main(String[] args) {


        List<User> userList = new ArrayList<>();
//        userList.add(new User(1, "Саша", "Андреев", "sasha", "sasha123"));
//        userList.add(new User(2, "Андрей", "Дмитриев", "andrey", "andrey123"));
//        userList.add(new User(3, "Алекс", "Шестаков", "alex", "alex123"));
//        userList.add(new User(4, "Дмитрий", "Буранов", "dima", "dima123"));
//        userList.add(new User(5, "Серёга", "Алексов", "serega", "serega123"));

        List<Account> accountList = new ArrayList<>();


        User.privetstviye();
//        Main();


    }


    static void Main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите из следующих пунктов: ...");

        while (true) {
            System.out.println("1. Информация об аккаунтах");
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


