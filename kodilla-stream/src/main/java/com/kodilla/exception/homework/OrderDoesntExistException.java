package com.kodilla.exception.homework;

public class OrderDoesntExistException extends Exception {

    public OrderDoesntExistException(String message) {
        super(message);
    }
}
