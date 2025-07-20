package com.kodilla.interfaces;

public class Triangle implements Shape {

    private double width;
    private double height;
    private double hypotenuse;

    public Triangle ( double width, double height, double hypotenuse){
        this.width = width;
        this.height = height;
        this.hypotenuse = hypotenuse;
    }
    @Override
    public double getArea() {
        return width * height / 2;
    }

    @Override
    public double getPerimeter() {

        return width + height + hypotenuse;
    }
}
