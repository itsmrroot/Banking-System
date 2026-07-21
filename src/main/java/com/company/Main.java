package com.company;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("First National");

        bank.addBranch("Downtown");
        bank.addCustomer("Downtown", "Alice", new BigDecimal("1000.00"));
        bank.addCustomerTransaction("Downtown", "Alice", new BigDecimal("-250.00"));
        bank.addCustomerTransaction("Downtown", "Alice", new BigDecimal("500.00"));

        bank.listCustomers("Downtown", true);
        System.out.println("Alice's balance: " + bank.getCustomerBalance("Downtown", "Alice"));
    }
}
