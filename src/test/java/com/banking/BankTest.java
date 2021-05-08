package com.banking;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.SortedSet;

public class BankTest {
    private Bank bank;
    private Customer customer;
    private String custID;
    private Account savingsAccount;

    // Test Fixture:
    @BeforeEach
    public void init() {
        bank = new Bank( "My Bank" );
        custID = bank.addCustomer("Piffl", "Hymie");
        customer = bank.getCustomer( custID );
        savingsAccount = customer.addSavingsAccount( 0.00, "Test Account" );
    }
    @Test
    public void testBankConstructor(){
        Bank bank1 = new Bank("Bank of Pollock");
        assertEquals("Bank of Pollock", bank1.getNAME());
    }

    // Test a deposit of $10.00 works:
    @Test
    @DisplayName("Account.deposit Tests")
    public void depositShouldIncreaseBalance () {
        final double initialBalance = savingsAccount.getBalance();
        final double amount = 10.00;
        savingsAccount.deposit( amount );
        final double finalBalance = savingsAccount.getBalance();
        assertEquals(finalBalance,initialBalance+amount,0);
    }

    @Test
    public void testBankMain(){
        // No Test Needed
    }

    @Test
    public void testAddCustomerGUI(){
        // No Test - Too difficult to test.
    }

    @Test
    @DisplayName("Bank test Add Customer")
    public void testAddCustomer(){
        Bank bank1;
        String cust;
        Customer customer1=null;
        bank1 = new Bank("Test Bank");
        cust = bank1.addCustomer("Pollock", "Wayne");
        assertNotNull(cust);
    }
    @Test
    @DisplayName("Bank test Add Customer #2")
    public void testAddCustomer2(){
        Bank bank1;
        String cust;
        Customer customer1=null;
        bank1 = new Bank("Test Bank");
        cust = bank1.addCustomer("Pollock", "Wayne");
        assertTrue(cust.length()>0);
    }

    @Test
    @DisplayName("Bank test Get Customer")
    public void testGetCustomer(){
        Bank bank1;
        String cust;
        Customer customer1=null;
        bank1 = new Bank("Test Bank");
        cust = bank1.addCustomer("Pollock", "Wayne");
        customer1=bank1.getCustomer(cust);
        assertNotNull(customer1);
    }

    @Test
    @DisplayName("Bank test: Get Customer (List)")
    public void testGetCustomer2(){
        List<Customer> custList;
        custList=bank.getCustomer("Piffl","Hymie");
        assertTrue(custList.size()>0, "Should return a list of matching Customer(s), list size>0");
    }

    @Test
    @DisplayName("Bank test: Get Customer (List)#2")
    public void testGetCustomer3(){
        List<Customer> custList;
        custList=bank.getCustomer("DoesNotExist","ThisGuy");
        assertTrue(custList.isEmpty(), "Should return an empty list");
    }

    @Test
    @DisplayName("Bank test: Get All Customers")
    public void testGetAllCustomers(){
        SortedSet<Customer> custList;
        custList=bank.getAllCustomers();
        assertTrue(custList.size()>0, "Should return a list of all customers, list size >0");
    }
    @Test
    @DisplayName("Bank test: Get All Customers #2")
    public void testgetAllCustomers2(){
        SortedSet<Customer> custList;
        custList=bank.getAllCustomers();
        bank.removeCustomer(custID);
        assertTrue(custList.size()>0,"Should return an empty list");
    }

    @Test
    @DisplayName("Bank test: Remove a customer")
    public void testRemoveCustomer(){
        //bank = new Bank( "My Bank" );
        bank.removeCustomer(custID);
        assertNull(bank.getCustomer(custID),"Should return a null object");

    }
}
