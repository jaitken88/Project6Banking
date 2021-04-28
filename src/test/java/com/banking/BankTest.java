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
    private Account savingsAccount2;
    private Account savingsAccount3;

    // Test Fixture:
    @BeforeEach
    public void init() {
        bank = new Bank( "My Bank" );
        custID = bank.addCustomer("Piffl", "Hymie");
        customer = bank.getCustomer( custID );
        savingsAccount = customer.addSavingsAccount( 0.00, "Test Account" );
    }
    @Test
    @DisplayName("Testing Bank Constructor #2")
    public void testBankConstructor(){
        Bank bank1 = new Bank("Bank of Pollock");
        assertEquals("Bank of Pollock", bank1.getNAME());
    }

    @Test
    @DisplayName("Testing Bank Constructor #2")
    public void testBankConstructor2(){
        Bank bank1 = new Bank(" ");
        assertThrows(IllegalArgumentException.class, () -> new Bank(" "));
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
    @DisplayName("Account.deposit Tests #2")
    public void testNegativeDeposit() {
        final double initialBalance = savingsAccount.getBalance();
        final double amount = -10.00;
        savingsAccount.deposit( amount );
        assertThrows(IllegalArgumentException.class,()->savingsAccount.deposit(amount));
    }

    @Test
    @DisplayName("Account.deposit Tests #3")
    public void testLargeDeposit() {
        final double initialBalance = savingsAccount.getBalance();
        final double amount = 999999999+9999999+999999999+999999999+789894984;
        savingsAccount.deposit( amount );
        assertThrows(IllegalArgumentException.class,()->savingsAccount.deposit(amount));
    }
    @Test
    @DisplayName("Account.deposit Tests #4")
    public void testZeroDeposit() {
        final double initialBalance = savingsAccount.getBalance();
        final double amount = 0;
        savingsAccount.deposit( amount );
        assertThrows(IllegalArgumentException.class,()->savingsAccount.deposit(amount));
    }

    @Test
    @DisplayName("Account.deposit Tests #5")
    public void testBlankDeposit() {
        final double initialBalance = savingsAccount.getBalance();
        final double amount = Integer.valueOf("");
        savingsAccount.deposit( amount );
        assertThrows(IllegalArgumentException.class,()->savingsAccount.deposit(amount));
    }

    @Test
    public void testBankMain(){
        String[] s={"123456789"};
        Bank.main(s);
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
        bank.removeCustomer(custID);
        custList=bank.getAllCustomers();
        assertTrue(custList.size()>0,"Should return an empty list");
    }

    @Test
    @DisplayName("Bank test: Get All Customers #3")
    public void testgetAllCustomers3(){
        Bank bank2=null;
        String custID2;
        bank2 = new Bank( "My Bank" );
        bank2.addCustomer("Piffl", "Hymie");
        bank2.addCustomer("Guarv", "Jose");
        bank2.addCustomer("Windez", "Fanz");
        bank2.addCustomer("Feeko", "Lamo");
        SortedSet<Customer> custList;
        custList=bank.getAllCustomers();
        assertTrue(custList.size()==4,"Should return a list with four items.");
    }

    @Test
    @DisplayName("Bank test: Get All Customers #4")
    public void testgetAllCustomers4(){
        Bank bank2=null;
        String custID2;
        bank2 = new Bank( "My Bank" );
        bank2.addCustomer("Piffl", "Hymie");
        bank2.addCustomer("Guarv", "Jose");
        bank2.addCustomer("Windez", "Fanz");
        bank2.addCustomer("Feeko", "Lamo");
        SortedSet<Customer> custList;
        custList=bank.getAllCustomers();
        assertEquals("Piffl",custList.first(), "Should return the first customer, Piffl");
    }

    @Test
    @DisplayName("Bank test: Remove a customer")
    public void testRemoveCustomer(){
        //bank = new Bank( "My Bank" );
        bank.removeCustomer(custID);
        assertNull(bank.getCustomer(custID),"Should return a null");
    }

    @Test
    @DisplayName("Bank test: Get all Accounts")
    public void testGetAllAccounts(){
        SortedSet<Account> accountList;
        accountList = bank.getAllAccounts();
        assertEquals(1, accountList.size(), "Account list should be equal to 1");
    }

    @Test
    @DisplayName("Bank test: Get all Accounts #2")
    public void testGetAllAccounts2(){
        savingsAccount2 = customer.addSavingsAccount( 0.00, "Second Account" );
        SortedSet<Account> accountList;
        accountList = bank.getAllAccounts();
        assertEquals(2, accountList.size(), "Account list should be equal to 2");
    }

    @Test
    @DisplayName("Bank test: Get all Accounts #3")
    public void testGetAllAccounts3(){
        savingsAccount2 = customer.addSavingsAccount( 0.00, "Second Account" );
        savingsAccount3 = customer.addSavingsAccount( 0.00, "Third Account" );
        SortedSet<Account> accountList;
        accountList = bank.getAllAccounts();
        assertEquals(3, accountList.size(), "Account list should be equal to 3");
    }




}
