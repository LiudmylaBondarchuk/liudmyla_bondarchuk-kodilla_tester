package com.kodilla.bank.homework;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    class CashMachineTest {

        @Test
        void shouldAddTransactionAndCalculateBalance() {
            // Given
            CashMachine atm = new CashMachine("Test ATM");

            // When
            atm.addTransaction(100);
            atm.addTransaction(-50);
            int balance = atm.getBalance();

            // Then
            assertEquals(50, balance);
        }

        @Test
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
        void shouldReturnCorrectAverageWithdrawalAndDeposit() {
            // Given
            CashMachine atm = new CashMachine("Test ATM");

            // When
            atm.addTransaction(100);
            atm.addTransaction(50);
            atm.addTransaction(-50);
            atm.addTransaction(-150);
            double avgDeposit = atm.getAverageDeposit();
            double avgWithdrawal = atm.getAverageWithdrawal();

            // Then
            assertEquals(75, avgDeposit);
            assertEquals(100, avgWithdrawal);
        }

        @Test
        void shouldHandleNoTransactionsGracefully() {
            // Given
            CashMachine atm = new CashMachine("Empty ATM");

            // When
            int balance = atm.getBalance();
            int depositsCount = atm.getDepositsCount();
            int withdrawalsCount = atm.getWithdrawalsCount();
            double avgDeposit = atm.getAverageDeposit();
            double avgWithdrawal = atm.getAverageWithdrawal();

            // Then
            assertEquals(0, balance);
            assertEquals(0, depositsCount);
            assertEquals(0, withdrawalsCount);
            assertEquals(0, avgDeposit);
            assertEquals(0, avgWithdrawal);
        }

        @Test
        void shouldIgnoreZeroTransactions() {
            // Given
            CashMachine atm = new CashMachine("Test ATM");

            // When
            atm.addTransaction(0);
            int balance = atm.getBalance();
            int depositsCount = atm.getDepositsCount();
            int withdrawalsCount = atm.getWithdrawalsCount();

            // Then
            assertEquals(0, balance);
            assertEquals(0, depositsCount);
            assertEquals(0, withdrawalsCount);
        }
    }

