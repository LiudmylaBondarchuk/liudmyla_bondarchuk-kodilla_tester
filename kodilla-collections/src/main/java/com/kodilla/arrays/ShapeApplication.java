package com.kodilla.arrays;

import com.kodilla.arrays.ShapeUtils;
import com.kodilla.interfaces.Circle;
import com.kodilla.interfaces.Shape;
import com.kodilla.interfaces.Square;
import com.kodilla.interfaces.Triangle;

import java.util.Random;

public class ShapeApplication {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];
        for (int n = 0; n < shapes.length; n++)
            shapes[n] = drawShape();
        for (Shape shape : shapes)
            ShapeUtils.displayShapeInfo(shape);
    }

    private static Shape drawShape() {
        int drawnShapeKind = RANDOM.nextInt(3);
        double a = getRandomSize();
        if (drawnShapeKind == 0)
            return new Circle(a);
        else if (drawnShapeKind == 1)
            return new Square(a);
        else {
            double b = getRandomSize();
            double c = getRandomSize();
            return new Triangle(a, b, c);
        }
    }

    private static double getRandomSize() {
        return RANDOM.nextDouble() * 100 + 1;
    }
}