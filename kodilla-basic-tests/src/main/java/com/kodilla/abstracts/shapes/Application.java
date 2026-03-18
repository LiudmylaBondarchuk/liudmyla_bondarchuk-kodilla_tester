package com.kodilla.abstracts.shapes;

public class Application {
    public static void main(String[] args) {
    Shape circle = new Circle(8);
    Shape rectangle = new Rectangle(98, 70.8);
    Shape triangle = new Triangle(7, 7.9, 12);
        printShapeInfo("Circle", circle);
        printShapeInfo("Rectangle", rectangle);
        printShapeInfo("Triangle", triangle);


    }

    private static void printShapeInfo(String name, Shape shape) {
        System.out.println(name + ":");
        System.out.println("Area: " + shape.calculateArea());
        System.out.println("Perimeter: " + shape.calculatePerimeter());
        System.out.println();
    }
}
