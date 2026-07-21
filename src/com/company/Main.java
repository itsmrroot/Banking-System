package com.company;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("First National");

        bank.addBranch("Downtown");
        bank.addCustomer("Downtown", "Alice", 1000.0);
        bank.addCustomerTransaction("Downtown", "Alice", -250.0);
        bank.addCustomerTransaction("Downtown", "Alice", 500.0);

        bank.listCustomers("Downtown", true);
        System.out.println("Alice's balance: " + bank.getCustomerBalance("Downtown", "Alice"));

    }
}
