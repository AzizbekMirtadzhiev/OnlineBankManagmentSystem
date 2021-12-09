package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class User implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private List<Account> accountList;
    private String login;
    private String password;
    private static List <Integer> ids = new ArrayList<>();

    public User(String firstName, String lastName, String login, String password, List <Account> accountList) {
        this.id = genUniqueId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.accountList = accountList;
    }




    public  void getInfo(){
        System.out.println("Ваше имя: " + getFirstName());
        System.out.println("Ваше фамилия: " + getLastName());
        System.out.println("Ваш id: " + getId());
        System.out.println("Ваш kgz счет: " + getAccountList().get(0).getBalance());
        System.out.println("Ваш usd счет: " + getAccountList().get(1).getBalance());


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
//
            for (int i = 0; i <Main.users.size() ; i++) {
            if (st.equals(Main.users.get(i).getLogin()) && pas.equals(Main.users.get(i).getPassword())){
                System.out.println("Вы вошли в систему...");
                Main.user = Main.users.get(i);
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


    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
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

    public List<Account> getAccountList() {
        return accountList;
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
