package com.banking;
import banking.Customer;
import banking.Bank;
import banking.Transaction.*;
import banking.Account;
import banking.SavingsAccount;
import banking.TransactionType;
import org.junit.*;  // The various annotations
import static org.junit.Assert.*; //AssertX methods

import org.junit.runner.JUnitCore; // Test runner

public class BankingTest {

    @Test
    public void testSavingsAccountConstructor1(){
        Bank bank = new Bank("Bank of Pollock");
        assertEquals("Bank of Pollock", bank.getNAME());
    }

    @Test
    public void testBankMain(){
        // No Test Needed
    }

    @Test
    public void testAddCustomerGUI(){
        Customer customer
    }
}
