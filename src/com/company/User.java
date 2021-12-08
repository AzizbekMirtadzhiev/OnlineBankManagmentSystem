package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private List<Account> accontList;
    private String login;
    private String password;
    private static List <Integer> ids = new ArrayList<>();

    public User() {
    }

    public User(String firstName, String lastName, String login, String password) {
        this.id = genUniqueId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }


    public static void privetstviye() {
        System.out.println("Добро пожаловать!");
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("1. Зарегистрироватся");
            System.out.println("2. Войти");

            try {


                int x = scanner.nextInt();
                if (x < 3 && x > 0) {
                    switch (x) {
                        case 1:
                            registrciya();
                            break;
                        case 2:
                            voyti();
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

    public static void registrciya() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя:");
        String name = scanner.nextLine();
        System.out.println("Введите ваше фамилию:");
        String lastName = scanner.nextLine();
        System.out.println("Введите ваш логин:");
        String login = scanner.nextLine();
        System.out.println("Введите ваш пароль:");
        String password = scanner.nextLine();
        User user = new User(name, lastName, login, password);
        Account account = new Account("KGZ", user);
        Account account2 = new Account("USD", user);
        List <Account> accountList = new ArrayList<>();
        accountList.add(account);
        accountList.add(account2);

        user.setAccontList(accountList);
//        user.getAccontList().add(account2);
        Main.user = user;


        System.out.println("Добавлен пользователь - ");
        user.getInfo();
        System.out.println("-------------------------------");
        Main.Main();
    }
    public  void getInfo(){
        System.out.println("Ваше имя: " + getFirstName());
        System.out.println("Ваш фамилия: " + getLastName());
        System.out.println("Ваш id: " + getId());
        System.out.println("Ваш kgz счет: " + getAccontList().get(0).getBalance());
        System.out.println("Ваш usd счет: " + getAccontList().get(1).getBalance());


    }
    public static int genUniqueId() {
        int id = 0;
        while (true) {
            id = new Random().nextInt(1000);
            if (checkForDuplicates(id)) {
                ids.add(id);
                break;
            }
        }
        return id;
    }

    private static boolean checkForDuplicates(int id) {
        for (int i : ids) {
            return i != id ;
        }

        return true;


    }


    public static void voyti() {
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите ваш аккаунт:");
            String st = scanner.nextLine();
            System.out.println("Введите ваш пароль:");
            String pas = scanner.nextLine();
        for (User u: Main.bank.getCastomers()) {
            if (u.getLogin().toLowerCase().equals(st) && u.getPassword().equals(pas)){
                System.out.println("Вы вошли в систему...");
                Main.user = u;
                Main.Main();
            } else {
                System.out.println("Неверный логин или пароль:" + " | Повторите попытку! ");
                voyti();
            }

        }

        }
    }

 /*   private static void addKgzBalance() {
        while (true){
            Scanner scanner = new Scanner(System.in);

//        System.out.println("Введите ваш id:");
//        String id = scanner.nextLine();
//        System.out.println("Введите ваш пароль:");
//        String password = scanner.nextLine();
            for (User u: Main.bank.getCastomers()) {
                System.out.println("Введите сумму платежа:");
                Main.bank.
//                LoggedUser.getAccountList().get(0).setBalance(LoggedUser.getAccountList().get(0).getBalance + platej);
//                User.
                try {

                    double platej = scanner.nextDouble();
                    System.out.println();
//                        u.getAccontList().get(0).getBalance() =  u.getAccontList().get(0).getBalance() += platej;

                }catch (Exception e ){
                    System.out.println("Введите числа! А не буквы!");
                }


            }

        }
//        Main.Main();
    }

  */


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
