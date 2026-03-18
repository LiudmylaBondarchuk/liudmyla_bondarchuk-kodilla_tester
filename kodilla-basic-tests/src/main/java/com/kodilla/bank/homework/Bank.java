package com.kodilla.bank.homework;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<CashMachine> cashMachines;

    public Bank() {
        this.cashMachines = new ArrayList<>();
    }

    public void addCashMachine(CashMachine cashMachine) {
        cashMachines.add(cashMachine);
    }

    public int getBalance() {
        int sum = 0;
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

    public double getAverageWithdrawal() {
        double sum = 0;
        int count = 0;
        for (CashMachine cashMachine : cashMachines) {
            sum += cashMachine.getAverageWithdrawal() * cashMachine.getWithdrawalsCount();
            count += cashMachine.getWithdrawalsCount();
        }
        if (count == 0) {
            return 0;
        }
        return sum / count;
    }

    public double getAverageDeposit() {
        double sum = 0;
        int count = 0;
        for (CashMachine cashMachine : cashMachines) {
            sum += cashMachine.getAverageDeposit() * cashMachine.getDepositsCount();
            count += cashMachine.getDepositsCount();
        }
        if (count == 0) {
            return 0;
        }
        return sum / count;
    }
}
