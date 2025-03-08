package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogInAccount {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

    public static void LogIn() throws IOException {
        System.out.println("-------------------------------------------------");
        System.out.println("1 - Отмена");
        System.out.print("Введите ваш email и пароль: ");
        String email = buffer.readLine();


        if (email.equals("1")){
            Main.GreetingsOfTheUser();
        }
        if (isValidEmail(email)) {
            String password = buffer.readLine();
            System.out.println("-------------------------------------------------");
            if (AccountRegistration.users.containsKey(email)) { // Проверяем, есть ли email
                User user = AccountRegistration.users.get(email); // Получаем объект User
                if (user.getPassword().equals(password)) {
                    System.out.println("Вход успешен!");
                    System.out.println("Добро пожаловать в наш финансовый сектор");//Можно сделать обращение по имени
                    TheEntranceIsCompleted(email,user);
                    System.out.println("-------------------------------------------------");

                } else {
                    System.out.println("-------------------------------------------------");
                    System.out.println("Неверный пароль!");
                    LogIn();
                }
            } else {
                System.out.println("Пользователь не найден!");
                LogIn();
            }
        } else {
            System.out.println("-------------------------------------------------");
            System.out.println("Не верный email");
            LogIn();
        }

    }
    public static void TheEntranceIsCompleted(String email,User user)throws IOException{
        System.out.println("-------------------------------------------------");
        System.out.println("Что вы хотите сделать в системе?");
        System.out.println("1 - Просмотр профиля\n" +
                "2 - Редактировать аккаунт\n" +
                "3 - Полностью заполнить профиль\n"+
                "4 - Добавить транзакцию\n"+
                "5 - Посмотртеть все транзакции\n" +
                "6 - Редактировать транзакию\n"+
                "7 - Удалить аккаунт\n" +
                "8 - Выход");
        System.out.println("-------------------------------------------------");
        int redact = Integer.parseInt(buffer.readLine());

        switch (redact){
            case 1:
                AccountCheck(email);
                TheEntranceIsCompleted(email,user);
                break;
            case 2:
                ProfileEditing(email);
                TheEntranceIsCompleted(email,user);
                break;
            case 3:
                user.FullFilling();
                TheEntranceIsCompleted(email,user);
                break;
            case 4:
                user.FullFilling();
                TheEntranceIsCompleted(email,user);
                break;
            case 5:
                user.getTransaction();
                TheEntranceIsCompleted(email,user);
            case 6:
                RedactTransaction(email,user);
                TheEntranceIsCompleted(email,user);
            case 7:
                DeliteUsers();
                Main.GreetingsOfTheUser();
                break;
            case 8:
                Main.GreetingsOfTheUser();
            default:
                System.out.println("-------------------------------------------------");
                System.out.println("Такой команды нет");
                LogIn();

        }
    }

    public static void AccountCheck(String email){
        System.out.println("-------------------------------------------------");
        User user = AccountRegistration.users.get(email);
        System.out.println("Ваш email: "  + email);
        System.out.println("Ваше имя: "  + user.getName());
        System.out.println("Ваш возраст: "  + user.getAge());
        System.out.println("Ваш пароль: "  + user.getPassword());
    }

    public static void ProfileEditing(String email) throws IOException{
        User user = AccountRegistration.users.get(email);
        System.out.println("-------------------------------------------------");
        System.out.println("Выберите что хотите редактировать");
        System.out.println("1 - email\n" +
                            "2 - пароль");
        System.out.println("-------------------------------------------------");
        int numberRedact = Integer.parseInt(buffer.readLine());

        switch (numberRedact){
            case 1:
                System.out.println("-------------------------------------------------");
                System.out.print("Введите новый email:");
                String newEmail = buffer.readLine();
                System.out.println("-------------------------------------------------");

                if (isValidEmail(email)) {
                    if (AccountRegistration.users.containsKey(newEmail)) {
                        System.out.println("-------------------------------------------------");
                        System.out.println("Ошибка: Такой email уже зарегистрирован!");

                        LogIn();
                    }
                    AccountRegistration.users.remove(email);
                    AccountRegistration.users.put(newEmail, user);
                    System.out.println("Email успешно изменён!");
                    break;
                }else{
                    System.out.println("-------------------------------------------------");
                    System.out.print("Ошбика данных");
                    LogIn();
                }


            case 2:
                System.out.println("-------------------------------------------------");
                System.out.println("Введите новый пароль");
                System.out.println("-------------------------------------------------");
                String newPassword = buffer.readLine();
                user.setPassword(newPassword);
                LogIn();
            default:
                System.out.println("Ошибка");
                ProfileEditing(email);
        }

    }

    public static void DeliteUsers() throws IOException{
        System.out.println("-------------------------------------------------");
        System.out.print("Введите повторно почту: ");
        String email = buffer.readLine();
        System.out.println("-------------------------------------------------");
        if (AccountRegistration.users.containsKey(email)){
            int rnd = (int) ((Math.random() * (10000 - 1000 + 1)) + 1000);
            System.out.println("Введите код без пробелов: " + rnd);
            System.out.println("-------------------------------------------------");
            int UserRnd = Integer.parseInt(buffer.readLine());

            if(rnd == UserRnd){
                AccountRegistration.users.remove(email);
                if (AccountRegistration.getUsers().size() < AccountRegistration.getSize()){
                    System.out.println("-------------------------------------------------");
                    System.out.println("Запись успешно удаленна");
                }
            }
        }
    }
    public static void RedactTransaction(String email,User user) throws IOException{
        System.out.println("-------------------------------------------------");
        System.out.println("Введите номер транзакции: ");
        System.out.println("0 - Назад ");

        System.out.println("-------------------------------------------------");
        int numberTransaction = Integer.parseInt(buffer.readLine());
        switch (numberTransaction){
            case 0:
                TheEntranceIsCompleted( email,user);
                break;

            default:
                 Transaction transaction = User.transactions.get(numberTransaction);
                 if(User.transactions.containsKey(numberTransaction)){
                     System.out.println("ID: " + numberTransaction);
                     System.out.println("Доход/Расход " + transaction.getIncome());
                     System.out.println("Дата тринзакции " + transaction.getDate_TrTransactions());
                     System.out.println("Категория " + transaction.getCategory());
                     System.out.println("Описание " + transaction.getDescription());
                     System.out.println("-------------------------------------------------");
                     System.out.println("Выберите что хотите редактировать\n" +
                             "1 - Сумму\n" +
                             "2 - Дату\n" +
                             "3 - Категория\n" +
                             "4 - Описание");

                     int vibor = Integer.parseInt(buffer.readLine());
                     switch (vibor){
                         case 1:
                             break;
                         case 2:
                             break;
                         case 3:
                             break;
                         case 4:
                             break;
                     }
                 }else {
                     System.out.println("Такой транзакции нет");
                     RedactTransaction(email,user);
                 }
        }




    }



    //public static void EditingTheAmount(int numberTransaction){


    //}

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
