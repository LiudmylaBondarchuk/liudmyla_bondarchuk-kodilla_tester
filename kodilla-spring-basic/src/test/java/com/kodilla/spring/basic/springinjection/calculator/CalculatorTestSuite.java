package com.kodilla.spring.basic.springinjection.calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Calculator Tests")
class CalculatorTestSuite {
    private static Calculator calculator;

    @BeforeAll
    static void setup() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        calculator = context.getBean(Calculator.class);
    }

    @Test
    @DisplayName("should add two numbers")
    void shouldAdd() {
        assertEquals(5.0, calculator.add(2, 3), 0.01);
    }
    @Test
    @DisplayName("should subtract two numbers")
    void shouldSubtract() {
        assertEquals(1.0, calculator.subtract(3, 2), 0.01);
    }
    @Test
    @DisplayName("should multiply two numbers")
    void shouldMultiply() {
        assertEquals(6.0, calculator.multiply(2, 3), 0.01);
    }
    @Test
    @DisplayName("should divide two numbers")
    void shouldDivide() {
        assertEquals(2.5, calculator.divide(5, 2), 0.01);
    }
    @Test
    @DisplayName("should throw on division by zero")
    void shouldThrowOnDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
    }
}
