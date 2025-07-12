package com.kodilla.basic_assertion;

public class ResultChecker {
    public static boolean assertEquals (int expected, int actual){
        return expected == actual;
    }
    public static boolean assertEquals(double expected, double actual, double delta) {
        return Math.abs(expected - actual) <= delta;
    }
}
