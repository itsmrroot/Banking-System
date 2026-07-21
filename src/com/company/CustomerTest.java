package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void balanceSumsAllTransactions() {
        Customer customer = new Customer("Alice", 1000.0);
        customer.addTransaction(-250.0);
        customer.addTransaction(500.0);

        assertEquals(1250.0, customer.getBalance());
    }

    @Test
    void newCustomerStartsWithInitialTransaction() {
        Customer customer = new Customer("Bob", 200.0);

        assertEquals(1, customer.getTransactions().size());
        assertEquals(200.0, customer.getTransactions().get(0));
    }
}
