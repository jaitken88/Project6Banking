package com.banking;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SavingsAccountTest {
    private Bank bank;
    private Customer customer;
    private String custID;
    private Account savingsAccount;
    private SavingsAccount test1;
    private SavingsAccount test2;
    private double interestRate;
    private double balance;
    private String account1;
    private String account2;

    // Test Fixture:
    @BeforeEach
    void setUp () {
        bank = new Bank( "My Bank" );
        custID = bank.addCustomer("Piffl", "Hymie");
        customer = bank.getCustomer( custID );
        savingsAccount = customer.addSavingsAccount( 0.00, "Test Account" );
        interestRate = 2.1;
        balance = 5.00;
        account1 = "First test";
        account2 = "Second test";
    }

    // Test the constructors in SavingsAccount
    @Test
    @DisplayName("SavingsAccount constructor tests")
    void testConstructors(){
        //test1 tests the SavingsAccount constructor that takes three parameters
        test1 = new SavingsAccount(customer, balance, account1);
        assertEquals(bank.getCustomer(test1.getCustomerId()), customer);
        assertEquals(test1.getBalance(), balance);
        assertEquals(test1.getAccountDescription(), account1);
        //test2 tests the SavingsAccount constructor that takes four parameters
        test2 = new SavingsAccount(customer, balance, account2, interestRate);
        assertEquals(bank.getCustomer(test1.getCustomerId()), customer);
        assertEquals(test2.getBalance(), balance);
        assertEquals(test2.getAccountDescription(), account2);
        assertEquals(test2.getDefaultInterestRate(), interestRate);
    }

    // Test a deposit of $10.00 works:
    @Test
    @DisplayName("Account.deposit Tests")
    void depositShouldIncreaseBalance () {
        final double initialBalance = savingsAccount.getBalance();
        final double amount = 10.00;
        savingsAccount.deposit( amount );
        final double finalBalance = savingsAccount.getBalance();
        assertEquals( finalBalance, initialBalance + amount,
                "Balance should be " +
                        (initialBalance+amount) + "but was " + finalBalance );
    }

    // Test a withdrawal of $10.00 works:
    @Test
    @DisplayName("Account.withdraw Tests")
    void withdrawalShouldDecreaseBalance () {
        final double initialBalance = savingsAccount.getBalance();
        final double amount = 10.00;
        savingsAccount.withdraw( amount );
        final double finalBalance = savingsAccount.getBalance();
        assertEquals( finalBalance, initialBalance - amount,
                "Balance should be " +
                        (initialBalance-amount) + "but was " + finalBalance );
    }


}
