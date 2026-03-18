package com.kodilla.abstracts.homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Shape Tests")
class ShapeTestSuite {

    @Test
    @DisplayName("should calculate circle area")
    void shouldCalculateCircleArea() {
        Circle circle = new Circle(5);
        assertEquals(Math.PI * 25, circle.calculateArea(), 0.01);
    }

    @Test
    @DisplayName("should calculate circle perimeter")
    void shouldCalculateCirclePerimeter() {
        Circle circle = new Circle(5);
        assertEquals(2 * Math.PI * 5, circle.calculatePerimeter(), 0.01);
    }

    @Test
    @DisplayName("should throw when circle radius is negative")
    void shouldThrowWhenCircleRadiusNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Circle(-1));
    }

    @Test
    @DisplayName("should calculate rectangle area")
    void shouldCalculateRectangleArea() {
        Rectangle rect = new Rectangle(4, 5);
        assertEquals(20, rect.calculateArea(), 0.01);
    }

    @Test
    @DisplayName("should calculate rectangle perimeter")
    void shouldCalculateRectanglePerimeter() {
        Rectangle rect = new Rectangle(4, 5);
        assertEquals(18, rect.calculatePerimeter(), 0.01);
    }

    @Test
    @DisplayName("should throw when rectangle has negative dimension")
    void shouldThrowWhenRectangleNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-1, 5));
    }

    @Test
    @DisplayName("should calculate triangle area using Heron formula")
    void shouldCalculateTriangleArea() {
        Triangle triangle = new Triangle(3, 4, 5);
        assertEquals(6.0, triangle.calculateArea(), 0.01);
    }

    @Test
    @DisplayName("should calculate triangle perimeter")
    void shouldCalculateTrianglePerimeter() {
        Triangle triangle = new Triangle(3, 4, 5);
        assertEquals(12.0, triangle.calculatePerimeter(), 0.01);
    }

    @Test
    @DisplayName("should throw when triangle sides are invalid")
    void shouldThrowWhenTriangleSidesInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 2, 10));
    }

    @Test
    @DisplayName("should throw when triangle has negative side")
    void shouldThrowWhenTriangleSideNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(-3, 4, 5));
    }
}
