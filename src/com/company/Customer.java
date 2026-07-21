package com.company;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialTransaction) {
        this.name = name;
        this.transactions = new ArrayList<>();
        this.transactions.add(initialTransaction);
    }

public String getName() {
    return name;
}

public ArrayList<Double> getTransactions() {
    return transactions;
}

public void addTransaction(double transaction) {
    this.transactions.add(transaction);
}

    public double getBalance() {
        double total = 0;
        for (double transaction : transactions) {
            total += transaction;
        }
        return total;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}
