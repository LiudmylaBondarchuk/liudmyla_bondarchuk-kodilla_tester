package com.kodilla;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Advanced Calculator Test Suite")
class AdvCalculatorTestSuite {

    private final AdvCalculator calculator = new AdvCalculator();

    @DisplayName("should add two numbers correctly")
    @Test
    void shouldAddTwoNumbers() {
        // given & when
        double result = calculator.compute("ADD", 3, 5);

        // then
        assertEquals(8.0, result, 0.001);
    }

    @DisplayName("should subtract two numbers correctly")
    @Test
    void shouldSubtractTwoNumbers() {
        // given & when
        double result = calculator.compute("SUB", 10, 4);

        // then
        assertEquals(6.0, result, 0.001);
    }

    @DisplayName("should multiply two numbers correctly")
    @Test
    void shouldMultiplyTwoNumbers() {
        // given & when
        double result = calculator.compute("MUL", 3, 7);

        // then
        assertEquals(21.0, result, 0.001);
    }

    @DisplayName("should divide two numbers correctly")
    @Test
    void shouldDivideTwoNumbers() {
        // given & when
        double result = calculator.compute("DIV", 10, 4);

        // then
        assertEquals(2.5, result, 0.001);
    }

    @DisplayName("should throw ArithmeticException when dividing by zero")
    @Test
    void shouldThrowExceptionWhenDividingByZero() {
        // given & when & then
        assertThrows(ArithmeticException.class, () -> calculator.compute("DIV", 10, 0));
    }
}
