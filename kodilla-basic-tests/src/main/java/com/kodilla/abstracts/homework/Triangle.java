package com.kodilla.abstracts.homework;

public class Triangle extends Shape{
    public double a;
    public double b;
    public double c;
    public Triangle (double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));

    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }
}
