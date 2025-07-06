package com.kodilla;

public class AdvCalcApplication {
    public static void main(String[] args) {
        AdvCalculator calculator = new AdvCalculator();
        double result = calculator.calculate();
        System.out.println("Result: " + result);
    }
}
