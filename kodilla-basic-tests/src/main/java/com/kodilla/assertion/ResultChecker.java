package com.kodilla.assertion;

// Educational demo — intentional reimplementation of assertion logic
public class ResultChecker {
    public static boolean assertEquals(int expected, int actual){
        return expected == actual;
    }
    public static boolean assertEquals(double expected, double actual, double delta) {
        return Math.abs(expected - actual) <= delta;
    }
}
