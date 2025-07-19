package com.kodilla.bank.homework;

public class Application {
    public static void main(String[] args) {
        Bank bank = new Bank();

        CashMachine atm1 = new CashMachine("Bankomat Centrum");
        atm1.addTransaction(100);
        atm1.addTransaction(-50);
        atm1.addTransaction(200);

        CashMachine atm2 = new CashMachine("Bankomat Dworzec");
        atm2.addTransaction(500);
        atm2.addTransaction(-150);

        bank.addCashMachine(atm1);
        bank.addCashMachine(atm2);

        bank.printCashMachinesSummary();

        System.out.println("----- Podsumowanie banku -----");
        printCashMachinesSummary(bank);
    }

    public static void printCashMachinesSummary(Bank bank) {
        System.out.println("Saldo banku: " + bank.getBalance());
        System.out.println("Liczba wpłat: " + bank.getDepositsCount());
        System.out.println("Liczba wypłat: " + bank.getWithdrawalsCount());
        System.out.println("Średnia wpłata: " + bank.getAverageDeposit());
        System.out.println("Średnia wypłata: " + bank.getAverageWithdrawal());
    }
}
