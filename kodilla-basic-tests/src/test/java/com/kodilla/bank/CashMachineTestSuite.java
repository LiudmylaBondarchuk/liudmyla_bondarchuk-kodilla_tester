package com.kodilla.bank;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CashMachine test suite")
class CashMachineTestSuite {

    @Test
    @DisplayName("should add transaction and calculate balance")
    void shouldAddTransactionAndCalculateBalance() {
        // Given
        CashMachine atm = new CashMachine("Test ATM");

        // When
        atm.addTransaction(100);
        atm.addTransaction(-50);
        long balance = atm.getBalance();

        // Then
        assertEquals(50L, balance);
    }

    @Test
    @DisplayName("should count withdrawals and deposits correctly")
    void shouldCountWithdrawalsAndDepositsCorrectly() {
        // Given
        CashMachine atm = new CashMachine("Test ATM");

        // When
        atm.addTransaction(100);
        atm.addTransaction(-50);
        atm.addTransaction(-25);
        int depositsCount = atm.getDepositsCount();
        int withdrawalsCount = atm.getWithdrawalsCount();

        // Then
        assertEquals(1, depositsCount);
        assertEquals(2, withdrawalsCount);
    }

    @Test
    @DisplayName("should return correct average withdrawal and deposit")
    void shouldReturnCorrectAverageWithdrawalAndDeposit() {
        // Given
        CashMachine atm = new CashMachine("Test ATM");

        // When
        atm.addTransaction(100);
        atm.addTransaction(50);
        atm.addTransaction(-50);
        atm.addTransaction(-150);
        BigDecimal avgDeposit = atm.getAverageDeposit();
        BigDecimal avgWithdrawal = atm.getAverageWithdrawal();

        // Then
        assertEquals(new BigDecimal("75.00"), avgDeposit);
        assertEquals(new BigDecimal("100.00"), avgWithdrawal);
    }

    @Test
    @DisplayName("should handle no transactions gracefully")
    void shouldHandleNoTransactionsGracefully() {
        // Given
        CashMachine atm = new CashMachine("Empty ATM");

        // When
        long balance = atm.getBalance();
        int depositsCount = atm.getDepositsCount();
        int withdrawalsCount = atm.getWithdrawalsCount();
        BigDecimal avgDeposit = atm.getAverageDeposit();
        BigDecimal avgWithdrawal = atm.getAverageWithdrawal();

        // Then
        assertEquals(0L, balance);
        assertEquals(0, depositsCount);
        assertEquals(0, withdrawalsCount);
        assertEquals(BigDecimal.ZERO, avgDeposit);
        assertEquals(BigDecimal.ZERO, avgWithdrawal);
    }

    @Test
    @DisplayName("should ignore zero transactions")
    void shouldIgnoreZeroTransactions() {
        // Given
        CashMachine atm = new CashMachine("Test ATM");

        // When
        atm.addTransaction(0);
        long balance = atm.getBalance();
        int depositsCount = atm.getDepositsCount();
        int withdrawalsCount = atm.getWithdrawalsCount();

        // Then
        assertEquals(0L, balance);
        assertEquals(0, depositsCount);
        assertEquals(0, withdrawalsCount);
    }
}
