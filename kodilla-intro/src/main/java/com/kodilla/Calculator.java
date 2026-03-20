package com.kodilla;

public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double square(double a) {
        return a * a;
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double circleArea(double r) {
        if (r < 0) {
            throw new IllegalArgumentException("radius must not be negative");
        }
        return Math.PI * r * r;
    }

    public double circlePerimeter(double r) {
        if (r < 0) {
            throw new IllegalArgumentException("radius must not be negative");
        }
        return 2 * Math.PI * r;
    }
}
