package com.kodilla.cucumber.wallet;

import java.util.Objects;

public class Cashier {
    private final CashSlot cashSlot;

    public Cashier(CashSlot cashSlot) {
        Objects.requireNonNull(cashSlot, "cashSlot must not be null");
        this.cashSlot = cashSlot;
    }

    public void withdraw(Wallet wallet, long amount) {
        Objects.requireNonNull(wallet, "wallet must not be null");
        wallet.debit(amount);
        cashSlot.dispense(amount);
    }
}
