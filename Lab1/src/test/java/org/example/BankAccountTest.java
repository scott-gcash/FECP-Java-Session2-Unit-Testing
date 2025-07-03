package org.example;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount(101, "Alice", 5000);
    }

    @Test
    void depositValidAmount() {
        bankAccount.deposit(500);
        assertEquals(5500, bankAccount.getAvailableBalance());
    }

    @Test
    void depositInvalidAmount() {
        bankAccount.deposit(-200);
        assertEquals(5000, bankAccount.getAvailableBalance());
    }

    @Test
    void withdrawValidAmount() {
        bankAccount.withdraw(300);
        assertEquals(4700, bankAccount.getAvailableBalance());
    }

    @Test
    void withdrawInvalidAmount() {
        bankAccount.withdraw(-50);
        assertEquals(5000, bankAccount.getAvailableBalance());
    }

    @Test
    void withdrawAmountGreaterThanBalance(){
        bankAccount.withdraw(6000);
        assertEquals(5000, bankAccount.getAvailableBalance());
    }

    @Test
    void testGetAccountNumber(){
        assertEquals(101, bankAccount.getAccountNumber());
    }

    @Test
    void testCreateBankAccountWithoutDeposit() {
        BankAccount emptyDeposit = new BankAccount(521, "Bob");
        assertEquals(0.0, emptyDeposit.getAvailableBalance());
        assertEquals(521, emptyDeposit.getAccountNumber());
        assertEquals("Bob", emptyDeposit.getBankAccountHolderName());
    }

    @Test
    void testDisplayInformation(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream printStream = System.out;
        System.setOut(new PrintStream(output));

        bankAccount.displayInformation();

        System.setOut(printStream);

        String outputOfMethod = output.toString();

        assertTrue(outputOfMethod.contains("Account Number: 101"));
        assertTrue(outputOfMethod.contains("Bank Holder Name: Alice"));
        assertTrue(outputOfMethod.contains("Available Balance: 5000.00"));
    }
}