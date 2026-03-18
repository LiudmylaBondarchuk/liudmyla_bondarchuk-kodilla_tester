package com.kodilla;

public class AdvCalculator {
    public double calculate() {
        String userSelected = UserDialogs.getUserSelection();
        int a = UserDialogs.getValue();
        int b = UserDialogs.getValue();
        return switch (userSelected) {
            case "ADD" -> a + b;
            case "SUB" -> a - b;
            case "DIV" -> {
                if (b == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                yield (double) a / b;
            }
            case "MUL" -> a * b;
            default -> throw new IllegalArgumentException("Unknown operation: " + userSelected);
        };
    }
}
