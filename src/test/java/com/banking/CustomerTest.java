package com.banking;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    private Bank bank;
    private Customer customer;
    private String custID;
    private SavingsAccount savingsAccount;
    private double initialBalance;
    private String newSavingsAccountDescription;
    private double rate;

    //test fixture
    @BeforeEach
    public void init() {
        bank = new Bank( "BEAM Bank" );
        custID = bank.addCustomer("Dude", "Cool");
        customer = bank.getCustomer( custID );
        initialBalance = 1000.0;
        newSavingsAccountDescription = "Test Savings Account";
        savingsAccount = customer.addSavingsAccount( initialBalance, newSavingsAccountDescription );
        rate = 2.1;
        savingsAccount.addInterestTransaction(rate);
    }
    //testing the constructor and methods in Constructor
    @Test
    @DisplayName ("Customer test constructor")
    public void testCustomerConstructor(){
        assertEquals(new Bank("BEAM Bank"), customer.getBank());
        assertEquals("Dude", customer.getLastName());
        assertEquals("Cool", customer.getFirstName());
    }
    @Test
    @DisplayName ("Customer test ytdInterest")
    public void testYTDInterest(){
        double ytdInterest = customer.ytdInterest();
        /*
        Only 1 day of interest should have been added So, the YTD interest of this account should
        be ((balance)*(1 + (newSavingsAccount.getDefaultInterestRate() * 0.01)*(1/365)))
         */
        assertEquals(ytdInterest, (initialBalance * rate * 0.01)*(1.0/365));
    }
    @Test
    @DisplayName ("Customer test addSavingsAccount")
    public void testAddSavingsAccount(){
        assertEquals(initialBalance, savingsAccount.getBalance());
        assertEquals(newSavingsAccountDescription, savingsAccount.getAccountDescription());
    }
    @Test
    @DisplayName ("Customer test removeAccount")
    public void testRemoveAccount(){
        customer.removeAccount(custID);
        assertNull(customer.getAccount(custID));
    }
}
