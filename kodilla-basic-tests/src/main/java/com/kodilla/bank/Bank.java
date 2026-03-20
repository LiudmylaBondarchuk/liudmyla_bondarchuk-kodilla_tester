package com.kodilla.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<CashMachine> cashMachines;

    public Bank() {
        this.cashMachines = new ArrayList<>();
    }

    public void addCashMachine(CashMachine cashMachine) {
        cashMachines.add(cashMachine);
    }

    public long getBalance() {
        long sum = 0;
        for (CashMachine cashMachine : cashMachines) {
            sum += cashMachine.getBalance();
        }
        return sum;
    }

    public int getWithdrawalsCount() {
        int count = 0;
        for (CashMachine cashMachine : cashMachines) {
            count += cashMachine.getWithdrawalsCount();
        }
        return count;
    }

    public int getDepositsCount() {
        int count = 0;
        for (CashMachine cashMachine : cashMachines) {
            count += cashMachine.getDepositsCount();
        }
        return count;
    }

    public BigDecimal getAverageWithdrawal() {
        long sum = 0;
        int count = 0;
        for (CashMachine cashMachine : cashMachines) {
            sum += cashMachine.getWithdrawalsSum();
            count += cashMachine.getWithdrawalsCount();
        }
        if (count == 0) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(sum).divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP);
    }

    public BigDecimal getAverageDeposit() {
        long sum = 0;
        int count = 0;
        for (CashMachine cashMachine : cashMachines) {
            sum += cashMachine.getDepositsSum();
            count += cashMachine.getDepositsCount();
        }
        if (count == 0) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(sum).divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP);
    }
}
