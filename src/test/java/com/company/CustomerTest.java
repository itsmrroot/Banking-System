package com.company;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void balanceSumsAllTransactions() {
        Customer customer = new Customer("Alice", new BigDecimal("1000.00"));
        customer.addTransaction(new BigDecimal("-250.00"));
        customer.addTransaction(new BigDecimal("500.00"));

        assertEquals(new BigDecimal("1250.00"), customer.getBalance());
    }

    @Test
    void newCustomerStartsWithInitialTransaction() {
        Customer customer = new Customer("Bob", new BigDecimal("200.00"));

        assertEquals(1, customer.getTransactions().size());
        assertEquals(new BigDecimal("200.00"), customer.getTransactions().get(0));
    }
}
