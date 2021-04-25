package com.banking;
import org.junit.*;  // The various annotations
import static org.junit.Assert.*; //AssertX methods
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.JUnitCore; // Test runner

import java.util.List;
import java.util.SortedSet;

public class BankTest {
    private Bank bank;
    private Customer customer;
    private String custID;
    private Account savingsAccount;

    // Test Fixture:
    @BeforeEach
    void setUp () {
        bank = new Bank( "My Bank" );
        custID = bank.addCustomer("Piffl", "Hymie");
        customer = bank.getCustomer( custID );
        savingsAccount = customer.addSavingsAccount( 0.00, "Test Account" );
    }
    @Test
    void testBankConstructor(){
        Bank bank = new Bank("Bank of Pollock");
        assertEquals("Bank of Pollock", bank.getNAME());
    }

    // Test a deposit of $10.00 works:
    @Test
    @DisplayName("Account.deposit Tests")
    void depositShouldIncreaseBalance () {
        final double initialBalance = savingsAccount.getBalance();
        final double amount = 10.00;
        savingsAccount.deposit( amount );
        final double finalBalance = savingsAccount.getBalance();
        assertEquals(finalBalance,initialBalance+amount,0);
    }

    @Test
    void testBankMain(){
        // No Test Needed
    }

    @Test
    void testAddCustomerGUI(){
        // No Test - Too difficult to test.
    }

    @Test
    @DisplayName("Bank test Add Customer")
    void testAddCustomer(){
        Bank bank1;
        String cust;
        Customer customer1=null;
        bank1 = new Bank("Test Bank");
        cust = bank1.addCustomer("Pollock", "Wayne");
        assertNotNull(cust);
    }
    @Test
    @DisplayName("Bank test Add Customer #2")
    void testAddCustomer2(){
        Bank bank1;
        String cust;
        Customer customer1=null;
        bank1 = new Bank("Test Bank");
        cust = bank1.addCustomer("Pollock", "Wayne");
        assertTrue(cust.length()>0);
    }

    @Test
    @DisplayName("Bank test Get Customer")
    void testGetCustomer(){
        Bank bank1;
        String cust;
        Customer customer1=null;
        bank1 = new Bank("Test Bank");
        cust = bank1.addCustomer("Pollock", "Wayne");
        customer1=bank1.getCustomer(cust);
        assertNotNull("Should not be null",customer1);
    }

    @Test
    @DisplayName("Bank test: Get Customer (List)")
    void testGetCustomer2(){
        List<Customer> custList;
        custList=bank.getCustomer("Piffl","Hymie");
        assertTrue("Should return a List of matching Customer(s), list size > 0",custList.size()>0);
    }

    @Test
    @DisplayName("Bank test: Get Customer (List)#2")
    void testGetCustomer3(){
        List<Customer> custList;
        custList=bank.getCustomer("DoesNotExist","ThisGuy");
        assertTrue("Should return an empty list",custList.isEmpty());
    }

    @Test
    @DisplayName("Bank test: Get All Customers")
    void testgetAllCustomers(){
        SortedSet<Customer> custList;
        custList=bank.getAllCustomers();
        assertTrue("Should return a list of all customers, list size >0",custList.size()>0);
    }
    @Test
    @DisplayName("Bank test: Get All Customers #2")
    void testgetAllCustomers2(){
        SortedSet<Customer> custList;
        custList=bank.getAllCustomers();
        bank.removeCustomer(custID);
        assertTrue("Should return an empty list",custList.size()>0);
    }



}
