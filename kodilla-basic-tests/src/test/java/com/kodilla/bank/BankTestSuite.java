package com.kodilla.bank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Bank test suite")
class BankTestSuite {

    @Test
    @DisplayName("should add cash machines and calculate overall balance")
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
    @DisplayName("should count total withdrawals and deposits across ATMs")
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
    @DisplayName("should calculate average deposits and withdrawals correctly")
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
        BigDecimal avgDeposit = bank.getAverageDeposit();
        BigDecimal avgWithdrawal = bank.getAverageWithdrawal();

        // Then
        assertEquals(new BigDecimal("150.00"), avgDeposit);
        assertEquals(new BigDecimal("35.00"), avgWithdrawal);
    }

    @Test
    @DisplayName("should return zero if no cash machines")
    void shouldReturnZeroIfNoCashMachines() {
        // Given
        Bank bank = new Bank();

        // When
        long balance = bank.getBalance();
        int depositsCount = bank.getDepositsCount();
        int withdrawalsCount = bank.getWithdrawalsCount();
        BigDecimal avgDeposit = bank.getAverageDeposit();
        BigDecimal avgWithdrawal = bank.getAverageWithdrawal();

        // Then
        assertEquals(0L, balance);
        assertEquals(0, depositsCount);
        assertEquals(0, withdrawalsCount);
        assertEquals(BigDecimal.ZERO, avgDeposit);
        assertEquals(BigDecimal.ZERO, avgWithdrawal);
    }
}
