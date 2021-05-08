package com.banking;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.SortedSet;

public class CustomerTest {
    private Customer cust;
    private Bank bank;
    private String firstName;
    private String lastName;

    //test fixture
    @BeforeEach
    public void init() {
        bank = new Bank("BEAM Bank");
        firstName = "Cool";
        lastName = "Dude";
        Customer cust1 = new Customer(bank, firstName, lastName);
    }
    //testing the constructor of the class Customer
    @Test
    public void testCustomerContructor(){
        Customer cust = new Customer(bank, firstName, lastName);
    }
    //testing the constructor of the class Customer
    @Test
    public void testytdFees(){
        cust.ytdFees();
    }
    //testing the constructor of the class Customer
    @Test
    public void testytdInterest(){
        cust.ytdInterest();
    }

}
