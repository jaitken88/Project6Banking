package com.banking;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    private Customer cust;
    private SavingsAccount newSavingsAccount;
    private double initialBalance;
    private String newSavingsAccountDescription;
    private double ytdInterest;
    //test fixture
    @BeforeEach
    public void init() {
        initialBalance = 0.0;
        newSavingsAccountDescription = "Test Savings Account";
    }
    //testing the constructor and methods in Constructor
    @Test
    @DisplayName ("Customer test constructor")
    public void testCustomerConstructor(){
        Customer cust = new Customer(new Bank("BEAM Bank"), "Dude", "Cool");
        assertEquals(new Bank("BEAM Bank"), cust.getBank());
        assertEquals("Dude", cust.getLastName());
        assertEquals("Cool", cust.getFirstName());
    }
    @Test
    @DisplayName ("Customer test ytdInterest")
    public void testYTDInterest(){
        ytdInterest = cust.ytdInterest();
        /*
        It has been 126 days since January 1st, 2021 (today is May 7th.) So, the YTD interest of this account should
        be ((balance)*(1 + (newSavingsAccount.getDefaultInterestRate() * 0.01)*(126/365)))
         */
        assertEquals(ytdInterest, (newSavingsAccount.getBalance())*(1 + (newSavingsAccount.getDefaultInterestRate() * 0.01)*(126/365)));
    }
    @Test
    @DisplayName ("Customer test addSavingsAccount")
    public void testAddSavingsAccount(){
        newSavingsAccount = cust.addSavingsAccount(initialBalance, newSavingsAccountDescription);
        assertEquals(initialBalance, newSavingsAccount.getBalance());
        assertEquals(newSavingsAccountDescription, newSavingsAccount.getAccountDescription());
    }
}
