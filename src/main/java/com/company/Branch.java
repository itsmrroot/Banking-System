package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, BigDecimal initialAmount) {

        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        if (initialAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Initial amount cannot be negative");
        }
        if (findCustomer(customerName) == null) {
            customers.add(new Customer(customerName, initialAmount));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName, BigDecimal amount) {

        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    public BigDecimal getCustomerBalance(String customerName) {
        Customer customer = findCustomer(customerName);
        if (customer != null) {
            return customer.getBalance();
        }
        return null;
    }

    private Customer findCustomer(String customerName) {

        for (int i = 0; i < customers.size(); i++) {
            Customer checkedCustomer = customers.get(i);
            if (checkedCustomer.getName().equals(customerName)) {
                return checkedCustomer;
            }
        }
        return null;
    }
}
