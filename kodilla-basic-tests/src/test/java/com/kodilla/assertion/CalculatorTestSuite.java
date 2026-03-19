package com.kodilla.assertion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Calculator test suite")
class CalculatorTestSuite {

    private static final double DELTA = 0.001;

    @Test
    @DisplayName("should sum two numbers")
    void testSum() {
        Calculator calculator = new Calculator();
        int sumResult = calculator.sum(5, 8);
        assertEquals(13, sumResult);
    }

    @Test
    @DisplayName("should subtract two numbers")
    void testSubtract() {
        Calculator calculator = new Calculator();
        int subtractResult = calculator.subtract(5, 8);
        assertEquals(-3, subtractResult);
    }

    @Test
    @DisplayName("should square a positive number")
    void testSquareWithPositive() {
        Calculator calculator = new Calculator();
        double squareResult = calculator.square(3);
        assertEquals(9.0, squareResult, DELTA);
    }

    @Test
    @DisplayName("should square zero")
    void testSquareWithZero() {
        Calculator calculator = new Calculator();
        double squareResult = calculator.square(0);
        assertEquals(0.0, squareResult, DELTA);
    }

    @Test
    @DisplayName("should square a negative number")
    void testSquareWithNegative() {
        Calculator calculator = new Calculator();
        double squareResult = calculator.square(-2);
        assertEquals(4.0, squareResult, DELTA);
    }
}
