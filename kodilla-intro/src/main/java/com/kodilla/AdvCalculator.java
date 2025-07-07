package com.kodilla;
public class AdvCalculator {
    public double calculate() {
        String userSelected = UserDialogs.getUserSelection();
        int a = UserDialogs.getValue();
        int b = UserDialogs.getValue();
        return switch (userSelected) {
            case "ADD" -> a + b;
            case "SUB" -> a - b;
            case "DIV" -> a / b;
            case "MUL" -> a * b;
            default -> 0;
        };
    }
}