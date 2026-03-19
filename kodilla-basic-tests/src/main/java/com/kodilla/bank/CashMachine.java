package com.kodilla.bank;

import java.util.ArrayList;
import java.util.List;

public class CashMachine {
    private final String name;
    private final List<Long> transactions;

    public CashMachine(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addTransaction(long amount) {
        if (amount == 0) {
            return;
        }
        transactions.add(amount);
    }

    public long getBalance() {
        long sum = 0;
        for (long value : transactions) {
            sum += value;
        }
        return sum;
    }

    public int getWithdrawalsCount() {
        int count = 0;
        for (long value : transactions) {
            if (value < 0) {
                count++;
            }
        }
        return count;
    }

    public int getDepositsCount() {
        int count = 0;
        for (long value : transactions) {
            if (value > 0) {
                count++;
            }
        }
        return count;
    }

    public double getAverageWithdrawal() {
        long sum = 0;
        int count = 0;
        for (long value : transactions) {
            if (value < 0) {
                sum += Math.abs(value);
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        return (double) sum / count;
    }

    public double getAverageDeposit() {
        long sum = 0;
        int count = 0;
        for (long value : transactions) {
            if (value > 0) {
                sum += value;
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        return (double) sum / count;
    }
}
