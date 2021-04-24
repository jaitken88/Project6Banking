package com.banking;
import org.junit.*;  // The various annotations
import static org.junit.Assert.*; //AssertX methods
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.JUnitCore; // Test runner

public class BankTest {
    private Bank bank;
    private Customer customer;
    private String custID;
    private SavingsAccount savingsAccount;

    // Test Fixture:
    @BeforeEach
    void setUp () {
        bank = new Bank( "My Bank" );
        custID = bank.addCustomer("Piffl", "Hymie");
        customer = bank.getCustomer( custID );
        savingsAccount = customer.addSavingsAccount( 0.00, "Test Account" );
    }





}
