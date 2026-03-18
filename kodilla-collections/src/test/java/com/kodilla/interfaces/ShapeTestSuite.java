package com.kodilla.interfaces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Shape implementations test suite")
class ShapeTestSuite {

    @Nested
    @DisplayName("Circle tests")
    class CircleTests {

        @Test
        @DisplayName("should calculate area for radius 5")
        void shouldCalculateArea() {
            // given
            Circle circle = new Circle(5);
            // when
            double area = circle.getArea();
            // then
            assertEquals(Math.PI * 25, area, 0.0001);
        }

        @Test
        @DisplayName("should calculate perimeter for radius 5")
        void shouldCalculatePerimeter() {
            // given
            Circle circle = new Circle(5);
            // when
            double perimeter = circle.getPerimeter();
            // then
            assertEquals(2 * Math.PI * 5, perimeter, 0.0001);
        }

        @Test
        @DisplayName("should calculate area for radius 1")
        void shouldCalculateAreaForUnitCircle() {
            // given
            Circle circle = new Circle(1);
            // then
            assertEquals(Math.PI, circle.getArea(), 0.0001);
        }

        @Test
        @DisplayName("should throw IllegalArgumentException for negative radius")
        void shouldThrowForNegativeRadius() {
            assertThrows(IllegalArgumentException.class, () -> new Circle(-3));
        }

        @Test
        @DisplayName("should throw IllegalArgumentException for zero radius")
        void shouldThrowForZeroRadius() {
            assertThrows(IllegalArgumentException.class, () -> new Circle(0));
        }
    }

    @Nested
    @DisplayName("Square tests")
    class SquareTests {

        @Test
        @DisplayName("should calculate area for width 4")
        void shouldCalculateArea() {
            // given
            Square square = new Square(4);
            // when
            double area = square.getArea();
            // then
            assertEquals(16.0, area, 0.0001);
        }

        @Test
        @DisplayName("should calculate perimeter for width 4")
        void shouldCalculatePerimeter() {
            // given
            Square square = new Square(4);
            // when
            double perimeter = square.getPerimeter();
            // then
            assertEquals(16.0, perimeter, 0.0001);
        }

        @Test
        @DisplayName("should throw IllegalArgumentException for negative width")
        void shouldThrowForNegativeWidth() {
            assertThrows(IllegalArgumentException.class, () -> new Square(-2));
        }

        @Test
        @DisplayName("should throw IllegalArgumentException for zero width")
        void shouldThrowForZeroWidth() {
            assertThrows(IllegalArgumentException.class, () -> new Square(0));
        }
    }

    @Nested
    @DisplayName("Triangle tests")
    class TriangleTests {

        @Test
        @DisplayName("should calculate perimeter for sides 3, 4, 5")
        void shouldCalculatePerimeter() {
            // given
            Triangle triangle = new Triangle(3, 4, 5);
            // when
            double perimeter = triangle.getPerimeter();
            // then
            assertEquals(12.0, perimeter, 0.0001);
        }

        @Test
        @DisplayName("should calculate area using Heron formula for 3-4-5 right triangle")
        void shouldCalculateAreaUsingHeron() {
            // given
            Triangle triangle = new Triangle(3, 4, 5);
            // when
            double area = triangle.getArea();
            // then  (3-4-5 right triangle: area = 0.5 * 3 * 4 = 6)
            assertEquals(6.0, area, 0.0001);
        }

        @Test
        @DisplayName("should calculate area for equilateral triangle with side 6")
        void shouldCalculateAreaForEquilateral() {
            // given
            Triangle triangle = new Triangle(6, 6, 6);
            // when
            double area = triangle.getArea();
            // then  (area = (sqrt(3)/4) * 6^2 = 9*sqrt(3))
            assertEquals(9 * Math.sqrt(3), area, 0.0001);
        }

        @Test
        @DisplayName("should throw IllegalArgumentException for negative side")
        void shouldThrowForNegativeSide() {
            assertThrows(IllegalArgumentException.class, () -> new Triangle(-1, 4, 5));
        }

        @Test
        @DisplayName("should throw IllegalArgumentException for zero side")
        void shouldThrowForZeroSide() {
            assertThrows(IllegalArgumentException.class, () -> new Triangle(3, 0, 5));
        }

        @Test
        @DisplayName("should throw IllegalArgumentException for invalid triangle (violates triangle inequality)")
        void shouldThrowForInvalidTriangle() {
            assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 2, 10));
        }

        @Test
        @DisplayName("should throw IllegalArgumentException for degenerate triangle (sum of two sides equals third)")
        void shouldThrowForDegenerateTriangle() {
            assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 2, 3));
        }
    }
}
