package com.kodilla;

public class AdvCalculator {
    public double calculate() {
        String userSelected = UserDialogs.getUserSelection();
        int a = UserDialogs.getValue();
        int b = UserDialogs.getValue();
        return compute(userSelected, a, b);
    }

    public double compute(String operation, int a, int b) {
        return switch (operation) {
            case "ADD" -> (double) a + b;
            case "SUB" -> (double) a - b;
            case "DIV" -> {
                if (b == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                yield (double) a / b;
            }
            case "MUL" -> (double) a * b;
            default -> throw new IllegalArgumentException("Unknown operation: " + operation);
        };
    }
}
