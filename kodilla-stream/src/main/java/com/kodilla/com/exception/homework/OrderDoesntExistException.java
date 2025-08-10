package com.kodilla.com.exception.homework;

public class OrderDoesntExistException extends Exception{
    private final String message;

    public OrderDoesntExistException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return  message;
    }
}
