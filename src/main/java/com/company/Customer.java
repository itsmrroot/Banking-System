package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<BigDecimal> transactions;

    public Customer(String name, BigDecimal initialTransaction) {
        this.name = name;
        this.transactions = new ArrayList<>();
        this.transactions.add(initialTransaction);
    }

    public String getName() {
        return name;
    }

    public ArrayList<BigDecimal> getTransactions() {
        return transactions;
    }

    public void addTransaction(BigDecimal transaction) {
        this.transactions.add(transaction);
    }

    public BigDecimal getBalance() {
        BigDecimal total = BigDecimal.ZERO;
        for (BigDecimal transaction : transactions) {
            total = total.add(transaction);
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
