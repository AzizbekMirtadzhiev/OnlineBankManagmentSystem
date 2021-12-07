package com.company;

import java.util.List;
import java.util.Scanner;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private List<Account> accontList;
    private String login;
    private String password;

    public User(int id, String firstName, String lastName, String login, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }

    public static void privetstviye() {
        System.out.println("Добро пожаловать!");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Зарегистрироватся");
            System.out.println("2. Войти");

            try {

                int registrOrVoyti = scanner.nextInt();
                if (registrOrVoyti == 1) {
                    registrciya();
                    break;
                }
                if (registrOrVoyti == 2) {
                    voyti();
                    break;

                } else{ System.out.println("Ошибка!");
                scanner.next();
                }


            } catch (Exception e) {
                System.out.println("Введите только цифры!");
            }
        }

    }

    public static void registrciya() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя:");
        String name = scanner.nextLine();
        System.out.println("Введите ваш пароль:");
        String password = scanner.nextLine();
        Account account = new Account(name, password);

        Main.user.getAccontList().add(account);
        System.out.println("Добавлен пользователь - ");
        account.getInfo();
        System.out.println("-------------------------------");
    }

    public static void voyti() {

    }


    public void setAccontList(List<Account> accontList) {
        this.accontList = accontList;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Account> getAccontList() {
        return accontList;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
