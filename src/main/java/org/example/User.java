package org.example;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String password;

    static HashMap<Integer, Transaction> transactions = new HashMap<>();
    static private int numberTransaction = 0;


    public User(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public void FullFilling() throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        numberTransaction++;

        System.out.println("Номер транзакции: "+ numberTransaction);
        System.out.println("Введите доход или расход: ");
        int incomeOrExpense = Integer.parseInt(buffer.readLine());
        System.out.println("Введите категорию: ");
        String category = buffer.readLine();

        System.out.println("Введите дату в формате dd-MM-yyyy:");

        try {
            String userInput = buffer.readLine(); // Читаем ввод пользователя

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            formatter.setLenient(false); // Строгая проверка формата

            Date date_TrTransactions = formatter.parse(userInput); // Преобразуем строку в Date

            System.out.println("По желанию вы можете узнать описание вашей транзакции");
            String description = buffer.readLine();
            System.out.println("Транзакция успешно добавлена! ");
            transactions.put(numberTransaction,new Transaction(incomeOrExpense,category,formatter.format(date_TrTransactions),description));
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода!");
        } catch (ParseException e) {
            System.out.println("Ошибка! Неверный формат даты.");
        }
    }

    public static void getTransaction() {
        System.out.println("-------------------------------------------------");
        for (Map.Entry<Integer, Transaction> entry : transactions.entrySet()) {
            int id = entry.getKey();
            Transaction t = entry.getValue();
            System.out.println("*********************************************");
            System.out.println("ID: " + id + ", Сумма: " + t.getIncome() + ", Категория: " + t.getCategory() + ", Дата: " + t.getDate_TrTransactions()+" , Описание: " + t.getDescription());
            }
        System.out.println("*********************************************");
    }
    public static HashMap<Integer, Transaction> getTransactions() {
        return new HashMap<>(transactions);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
