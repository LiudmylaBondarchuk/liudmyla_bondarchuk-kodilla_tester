package com.kodilla.cucumber.wallet;

public class InsufficientFundsException extends RuntimeException {

    public InsufficientFundsException(long requested, long available) {
        super("Insufficient funds: requested " + requested
                + ", available " + available);
    }
}
