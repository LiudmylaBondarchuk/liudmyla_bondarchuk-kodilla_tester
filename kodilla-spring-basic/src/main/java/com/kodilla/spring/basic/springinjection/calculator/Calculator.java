package com.kodilla.spring.basic.springinjection.calculator;
import org.springframework.stereotype.Component;
@Component
public class Calculator {
    private final Display display;
    public Calculator(Display display) {
        this.display = display;
    }
    public double add(double a, double b) {
        double result = a + b;
        display.display(result);
        return result;
    }
    public double subtract(double a, double b) {
        double result = a - b;
        display.display(result);
        return result;
    }
    public double multiply(double a, double b) {
        double result = a * b;
        display.display(result);
        return result;
    }
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        double result = a / b;
        display.display(result);
        return result;
    }
}
