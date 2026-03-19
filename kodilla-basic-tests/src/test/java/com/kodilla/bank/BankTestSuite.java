package com.kodilla.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankTestSuite {

    @Test
    void shouldAddCashMachinesAndCalculateOverallBalance() {
        // Given
        Bank bank = new Bank();
        CashMachine atm1 = new CashMachine("ATM 1");
        atm1.addTransaction(100);
        atm1.addTransaction(-20);
        CashMachine atm2 = new CashMachine("ATM 2");
        atm2.addTransaction(200);
        atm2.addTransaction(-50);

        // When
        bank.addCashMachine(atm1);
        bank.addCashMachine(atm2);
        long balance = bank.getBalance();

        // Then
        assertEquals(230L, balance);
    }

    @Test
    void shouldCountTotalWithdrawalsAndDepositsAcrossATMs() {
        // Given
        Bank bank = new Bank();
        CashMachine atm1 = new CashMachine("ATM 1");
        atm1.addTransaction(100);
        atm1.addTransaction(-20);
        atm1.addTransaction(-10);
        CashMachine atm2 = new CashMachine("ATM 2");
        atm2.addTransaction(200);
        atm2.addTransaction(-50);

        // When
        bank.addCashMachine(atm1);
        bank.addCashMachine(atm2);
        int depositsCount = bank.getDepositsCount();
        int withdrawalsCount = bank.getWithdrawalsCount();

        // Then
        assertEquals(2, depositsCount);
        assertEquals(3, withdrawalsCount);
    }

    @Test
    void shouldCalculateAverageDepositsAndWithdrawalsCorrectly() {
        // Given
        Bank bank = new Bank();
        CashMachine atm1 = new CashMachine("ATM 1");
        atm1.addTransaction(100);
        atm1.addTransaction(-20);
        CashMachine atm2 = new CashMachine("ATM 2");
        atm2.addTransaction(200);
        atm2.addTransaction(-50);

        // When
        bank.addCashMachine(atm1);
        bank.addCashMachine(atm2);
        double avgDeposit = bank.getAverageDeposit();
        double avgWithdrawal = bank.getAverageWithdrawal();

        // Then
        assertEquals(150, avgDeposit);
        assertEquals(35, avgWithdrawal);
    }

    @Test
    void shouldReturnZeroIfNoCashMachines() {
        // Given
        Bank bank = new Bank();

        // When
        long balance = bank.getBalance();
        int depositsCount = bank.getDepositsCount();
        int withdrawalsCount = bank.getWithdrawalsCount();
        double avgDeposit = bank.getAverageDeposit();
        double avgWithdrawal = bank.getAverageWithdrawal();

        // Then
        assertEquals(0L, balance);
        assertEquals(0, depositsCount);
        assertEquals(0, withdrawalsCount);
        assertEquals(0, avgDeposit);
        assertEquals(0, avgWithdrawal);
    }
}
