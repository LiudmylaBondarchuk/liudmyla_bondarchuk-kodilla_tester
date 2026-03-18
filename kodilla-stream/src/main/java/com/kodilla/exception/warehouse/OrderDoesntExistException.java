package com.kodilla.exception.warehouse;

public class OrderDoesntExistException extends Exception {

    public OrderDoesntExistException(String message) {
        super(message);
    }
}
