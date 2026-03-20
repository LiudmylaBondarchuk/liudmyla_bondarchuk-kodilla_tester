package com.kodilla.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.LongPredicate;

public class CashMachine {
    private final String name;
    private final List<Long> transactions;

    public CashMachine(String name) {
        Objects.requireNonNull(name, "name must not be null");
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

    public BigDecimal getAverageWithdrawal() {
        return averageOfFiltered(value -> value < 0);
    }

    public BigDecimal getAverageDeposit() {
        return averageOfFiltered(value -> value > 0);
    }

    public long getDepositsSum() {
        return sumOfFiltered(value -> value > 0);
    }

    public long getWithdrawalsSum() {
        return sumOfFiltered(value -> value < 0);
    }

    private long sumOfFiltered(LongPredicate filter) {
        long sum = 0;
        for (long value : transactions) {
            if (filter.test(value)) {
                sum += Math.abs(value);
            }
        }
        return sum;
    }

    private BigDecimal averageOfFiltered(LongPredicate filter) {
        long sum = 0;
        int count = 0;
        for (long value : transactions) {
            if (filter.test(value)) {
                sum += Math.abs(value);
                count++;
            }
        }
        if (count == 0) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(sum).divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP);
    }
}
