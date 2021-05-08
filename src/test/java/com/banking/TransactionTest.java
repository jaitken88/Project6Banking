package com.banking;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TransactionTest {
    private TransactionType type;
    private double amount;
    private String description;
    private Transaction transaction;

    //Test Fixture
    @BeforeEach
    public void init(){
        type = TransactionType.DEPOSIT;
        amount = 20.00;
        description = "Test Deposit Transaction";
    }

    //Test the constructor for Transaction
    @Test
    @DisplayName("Transaction constructor test")
    public void testConstructor(){
        transaction = new Transaction(type, amount, description);
        assertEquals(type,transaction.getType());
        assertEquals(amount,transaction.getAmount());
        assertEquals(description,transaction.getDescription());
    }

}
