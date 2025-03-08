package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AccountRegistration {
    static HashMap<String, User> users = new HashMap<>();
    private static int size = 0;

    public static void EnteringAPassword() throws IOException {
        System.out.println("-------------------------------------------------");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1 - Отмена");
        System.out.print("Введите ваш email: ");
        String email = buffer.readLine();



        if (email.equals("1")){
            Main.GreetingsOfTheUser();
        }


        if (LogInAccount.isValidEmail(email)) {
            System.out.println("-------------------------------------------------");
            System.out.print("Введите имя: ");
            String name = buffer.readLine();
            System.out.println("-------------------------------------------------");

            System.out.print("Введите возраст: ");
            int age = Integer.parseInt(buffer.readLine());
            System.out.println("-------------------------------------------------");

            if (age <= 0 || age > 100){
                System.out.println("Введите корректный возраст");
                EnteringAPassword();
            }


            System.out.print("Введите ваш пароль: ");
            String password = buffer.readLine();
            if (password.length() < 8) {
                while (true) {
                    System.out.println("-------------------------------------------------");
                    System.out.println("Ошибка, вы ввели меньше 8 символов\nповторите попытку.");
                    System.out.println("-------------------------------------------------");
                    password = buffer.readLine();
                    if (password.length() >= 8) {
                        break;
                    }
                }
            }
            User printUser = new User(name, age, password);
            users.put(email, printUser);

            if (users.size()>size){
                size++;
                System.out.println("-------------------------------------------------");
                System.out.println("Вы успешно зарегистрировались ");
                Main.GreetingsOfTheUser();
            }else if (AccountRegistration.users.containsKey(email)){
                System.out.println("-------------------------------------------------");
                System.out.println("Ошибка, такой пользователь уже зарегистрированн.");
                System.out.println("-------------------------------------------------");
                EnteringAPassword();
            }
        }else{
            System.out.println("Не верный email");
            EnteringAPassword();
        }





    }
    public static HashMap<String,User> getUsers(){
        return new HashMap<>(users);
    }
    public static int getSize(){
        return size;
    }



}
