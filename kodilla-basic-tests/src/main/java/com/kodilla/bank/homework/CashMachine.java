package com.kodilla.bank.homework;

public class CashMachine {
    private String name;
    private int[] transactions;
    private int size;

    public CashMachine(String name) {
        this.name = name;
        this.transactions = new int[0];
        this.size = 0;
    }

    public String getName() {
        return name;
    }

    public void addTransaction(int amount){
        if (amount == 0){
            return;
        }
        this.size++;
        int[] newTab = new int[this.size];
        for (int i = 0; i < this.transactions.length; i++){
            newTab[i] = this.transactions[i];
        }
        newTab[this.size - 1] = amount;
        this.transactions = newTab;
    }

    public int getBalance(){
        int sum = 0;
        for (int value : transactions){
            sum += value;
        }
        return sum;
    }

    public int getWithdrawalsCount(){
        int count = 0;
        for(int value : transactions){
            if (value < 0){
                count++;
            }
        }
        return count;
    }

    public int getDepositsCount() {
        int count = 0;
        for (int value : transactions) {
            if (value > 0) {
                count++;
            }
        }
        return count;
    }

    public double getAverageWithdrawal() {
        int sum = 0;
        int count = 0;
        for (int value : transactions) {
            if (value < 0) {
                sum += Math.abs(value);
                count++;
            }
        }
        if(count == 0) {
            return 0;
        } else {
            return (double) sum / count;
        }
    }

    public double getAverageDeposit() {
        int sum = 0;
        int count = 0;
        for (int value : transactions) {
            if (value > 0) {
                sum += value;
                count++;
            }
        }
        if (count == 0) {
            return 0;
        } else {
            return (double) sum / count;
        }
    }
}