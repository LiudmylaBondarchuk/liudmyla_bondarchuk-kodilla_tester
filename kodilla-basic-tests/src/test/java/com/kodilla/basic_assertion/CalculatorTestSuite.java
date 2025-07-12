package com.kodilla.basic_assertion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTestSuite {
    @Test
    public void testSum(){
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 8;
        int sumResult = calculator.sum(a, b);
        assertEquals (13, sumResult);
    }
    @Test
    public void testSubtract(){
        Calculator calculator = new Calculator();
        int subtractResalt = calculator.subtract(5,8 );
        assertEquals(-3, subtractResalt );
    }
    @Test
    public void testSquareWithPositive(){
        Calculator calculator = new Calculator();
        double squareResult = calculator.square(3);
        assertEquals(9.0, squareResult, 0.1);
        }

    @Test
    public void testSquareWithZero(){
        Calculator calculator = new Calculator();
        double squareResult = calculator.square(0);
        assertEquals(0.0, squareResult, 0.1);
        }

    public void testSquareWithNegative(){
        Calculator calculator = new Calculator();
        double squareResult = calculator.square(-2);
        assertEquals(4, squareResult, 0.1);
    }

}
