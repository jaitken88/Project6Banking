package com.banking;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.SortedSet;

public class TransactionTypeTest {
    //Test for all enum constants
    @Test
    @DisplayName("TransactionType test")
        public void testTransactionType(){
        assertNotNull("DEPOSIT");
        assertNotNull("WITHDRAWAL");
        assertNotNull("INTEREST");
        assertNotNull("CHECK");
        assertNotNull("FEE");
        assertNotNull("PENALTY");
        assertNotNull("ADJUSTMENT");
    }
}
