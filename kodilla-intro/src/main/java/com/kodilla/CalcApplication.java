package com.kodilla;

public class CalcApplication {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double area = calculator.circleArea(10);
        System.out.println("Area of the Circle with radius 10 equals: " + area);
        System.out.println("The value of pi constant is equal to " + Math.PI);
    }
}
