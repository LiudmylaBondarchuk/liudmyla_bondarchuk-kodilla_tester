package com.kodilla.bank.homework;

public class Bank {
    private CashMachine[] cashMachines;
    private int size;

    public Bank() {
        this.cashMachines = new CashMachine[0];
        this.size = 0;
    }

    public void addCashMachine(CashMachine cashMachine) {
        this.size++;
        CashMachine[] newTab = new CashMachine[this.size];
        for (int i = 0; i < this.cashMachines.length; i++) {
            newTab[i] = this.cashMachines[i];
        }
        newTab[this.size - 1] = cashMachine;
        this.cashMachines = newTab;
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
        int sum = 0;
        int count = 0;
        for (CashMachine cashMachine : cashMachines) {
            sum += cashMachine.getAverageWithdrawal() * cashMachine.getWithdrawalsCount();
            count += cashMachine.getWithdrawalsCount();
        }
        if (count == 0) {
            return 0;
        } else {
            return (double) sum / count;
        }
    }

    public double getAverageDeposit() {
        int sum = 0;
        int count = 0;
        for (CashMachine cashMachine : cashMachines) {
            sum += cashMachine.getAverageDeposit() * cashMachine.getDepositsCount();
            count += cashMachine.getDepositsCount();
        }
        if (count == 0) {
            return 0;
        } else {
            return (double) sum / count;
        }
    }
    public void printCashMachinesSummary() {
        for (CashMachine cashMachine : cashMachines) {
            System.out.println("Bankomat: " + cashMachine.getName());
            System.out.println("Saldo: " + cashMachine.getBalance());
            System.out.println("Liczba wpłat: " + cashMachine.getDepositsCount());
            System.out.println("Liczba wypłat: " + cashMachine.getWithdrawalsCount());
            System.out.println("Średnia wpłata: " + cashMachine.getAverageDeposit());
            System.out.println("Średnia wypłata: " + cashMachine.getAverageWithdrawal());
            System.out.println();
        }
    }
}
