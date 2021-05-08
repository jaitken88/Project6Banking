package com.banking;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SavingsAccountTest {
    private Bank bank;
    private Customer customer;
    private String custID;
    private SavingsAccount savingsAccount;
    private SavingsAccount testSavingsAccount1;
    private SavingsAccount testSavingsAccount2;
    private double interestRate;
    private double balance;
    private double transfer;
    private double initialBalance;
    private String newSavingsAccountDescription;
    private String testSavingsAccount1Description;
    private String testSavingsAccount2Description;

    // Test Fixture:
    @BeforeEach
    void setUp () {
        bank = new Bank( "BEAM Bank" );
        custID = bank.addCustomer("Dude", "Cool");
        customer = bank.getCustomer( custID );
        initialBalance = 1000.0;
        newSavingsAccountDescription = "Test Savings Account";
        savingsAccount = customer.addSavingsAccount( 0.00,newSavingsAccountDescription);
        interestRate = 2.1;
        testSavingsAccount1Description = "Test Savings Account1";
        testSavingsAccount2Description = "Test Savings Account2";

    }

    // Test the constructors in SavingsAccount
    @Test
    @DisplayName("SavingsAccount constructor tests")
    void testConstructors(){
        //test1 tests the SavingsAccount constructor that takes three parameters
        testSavingsAccount1 = new SavingsAccount(customer, initialBalance, testSavingsAccount1Description);
        assertEquals(bank.getCustomer(testSavingsAccount1.getCustomerId()), customer);
        assertEquals(testSavingsAccount1.getBalance(), initialBalance);
        assertEquals(testSavingsAccount1.getAccountDescription(), testSavingsAccount1Description);
        //test2 tests the SavingsAccount constructor that takes four parameters
        testSavingsAccount2 = new SavingsAccount(customer, balance, testSavingsAccount2Description, interestRate);
        assertEquals(bank.getCustomer(testSavingsAccount2.getCustomerId()), customer);
        assertEquals(testSavingsAccount2.getBalance(), initialBalance);
        assertEquals(testSavingsAccount2.getAccountDescription(), testSavingsAccount2Description);
        assertEquals(testSavingsAccount2.getDefaultInterestRate(), interestRate);
    }

    // Test a deposit of $10.00 works:
    @Test
    @DisplayName("Account.deposit Tests")
    void depositShouldIncreaseBalance () {
        final double startingBalance = savingsAccount.getBalance();
        final double amount = 10.00;
        savingsAccount.deposit( amount );
        final double finalBalance = savingsAccount.getBalance();
        assertEquals( finalBalance, startingBalance + amount,
                "Balance should be " +
                        (startingBalance+amount) + "but was " + finalBalance );
    }

    // Test a withdrawal of $10.00 works:
    @Test
    @DisplayName("Account.withdrawal Tests")
    void withdrawalShouldDecreaseBalance () {
        final double startingBalance = savingsAccount.getBalance();
        final double amount = 10.00;
        savingsAccount.withdraw( amount );
        final double finalBalance = savingsAccount.getBalance();
        assertEquals( finalBalance, startingBalance - amount,
                "Balance should be " +
                        (startingBalance-amount) + "but was " + finalBalance );
    }

    //Test a transfer of 10.00 from testSavingsAccount1 to testSavingsAccount2
    @Test
    @DisplayName("Account.transfer Test")
    void transferBetweenAccounts(){
        final double transfer = 100.00;
        final double testSavingsAccount1startingBalance = testSavingsAccount1.getBalance();
        final double testSavingsAccount2startingBalance = testSavingsAccount2.getBalance();
        testSavingsAccount1.transfer(testSavingsAccount1, testSavingsAccount2,transfer);
        assertEquals(testSavingsAccount1startingBalance - transfer, testSavingsAccount1.getBalance());
        assertEquals(testSavingsAccount2startingBalance + transfer, testSavingsAccount2.getBalance());
    }
}
