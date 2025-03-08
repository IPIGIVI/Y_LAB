package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("-------------------------------------------------");
        System.out.println("Здраствуй, ты зашёл к нам в приложение");
        System.out.println("Ты хочешь зайти или зарегистрироваться?");
        GreetingsOfTheUser();

    }

    public static void GreetingsOfTheUser() throws IOException {
        System.out.println("-------------------------------------------------");
        System.out.println("1 - Зайти \n2 - Зарегистрироваться \n3 - Закрыть");
        System.out.println("-------------------------------------------------");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int thatTheUserWillIntroduce = Integer.parseInt(buffer.readLine());
        switch (thatTheUserWillIntroduce){
            case 1:
                LogInAccount.LogIn();
                break;
            case 2:
                AccountRegistration.EnteringAPassword();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("вы ввели не известную цифру");
                System.out.println("-------------------------------------------------");
                GreetingsOfTheUser();
        }


    }
}