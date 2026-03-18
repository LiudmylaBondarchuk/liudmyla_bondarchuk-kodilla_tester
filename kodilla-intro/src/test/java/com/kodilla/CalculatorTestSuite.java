package com.kodilla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Test Suite")
class CalculatorTestSuite {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("should add two doubles correctly")
    @Test
    void testAdd() {
        // when
        double result = calculator.add(3.5, 2.5);

        // then
        assertEquals(6.0, result, 0.001);
    }

    @DisplayName("should add negative doubles correctly")
    @Test
    void testAddNegativeNumbers() {
        // when
        double result = calculator.add(-3.0, -7.0);

        // then
        assertEquals(-10.0, result, 0.001);
    }

    @DisplayName("should subtract two doubles correctly")
    @Test
    void testSub() {
        // when
        double result = calculator.sub(10.0, 3.0);

        // then
        assertEquals(7.0, result, 0.001);
    }

    @DisplayName("should return correct square of a number")
    @Test
    void testSquare() {
        // when
        double result = calculator.square(5.0);

        // then
        assertEquals(25.0, result, 0.001);
    }

    @DisplayName("should return zero when squaring zero")
    @Test
    void testSquareOfZero() {
        // when
        double result = calculator.square(0.0);

        // then
        assertEquals(0.0, result, 0.001);
    }

    @DisplayName("should sum two integers correctly")
    @Test
    void testSum() {
        // when
        int result = calculator.sum(4, 6);

        // then
        assertEquals(10, result);
    }

    @DisplayName("should subtract two integers correctly")
    @Test
    void testSubtract() {
        // when
        int result = calculator.subtract(10, 4);

        // then
        assertEquals(6, result);
    }

    @DisplayName("should calculate circle area correctly")
    @Test
    void testCircleArea() {
        // when
        double result = calculator.circleArea(5.0);

        // then
        assertEquals(Math.PI * 25.0, result, 0.001);
    }

    @DisplayName("should return zero area for radius zero")
    @Test
    void testCircleAreaWithZeroRadius() {
        // when
        double result = calculator.circleArea(0.0);

        // then
        assertEquals(0.0, result, 0.001);
    }

    @DisplayName("should calculate circle perimeter correctly")
    @Test
    void testCirclePerimeter() {
        // when
        double result = calculator.circlePerimeter(5.0);

        // then
        assertEquals(2 * Math.PI * 5.0, result, 0.001);
    }

    @DisplayName("should return zero perimeter for radius zero")
    @Test
    void testCirclePerimeterWithZeroRadius() {
        // when
        double result = calculator.circlePerimeter(0.0);

        // then
        assertEquals(0.0, result, 0.001);
    }
}
