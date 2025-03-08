package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    private int  income;
    //private int expense;
    private String date_TrTransactions;
    private String category;
    private String description;

    public Transaction(int income, String category,String date_TrTransactions,String description) {
        this.income = income;
        //this.expense = expense;
        this.date_TrTransactions = date_TrTransactions;
        this.category = category;
        this.description = description;
    }

    public int getIncome() {
        return income;
    }

    public String getDate_TrTransactions() {

        return date_TrTransactions;
    }

    public String getCategory() {
        return category;
    }
    public  String getDescription(){return description;}

}
