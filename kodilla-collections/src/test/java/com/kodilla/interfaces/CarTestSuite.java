package com.kodilla.interfaces;

import com.kodilla.interfaces.cars.Car;
import com.kodilla.interfaces.cars.Ford;
import com.kodilla.interfaces.cars.Opel;
import com.kodilla.interfaces.cars.Toyota;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Car implementations test suite")
class CarTestSuite {

    @Nested
    @DisplayName("Ford tests")
    class FordTests {

        @Test
        @DisplayName("should return name Ford")
        void shouldReturnName() {
            Car ford = new Ford();
            assertEquals("Ford", ford.getName());
        }

        @Test
        @DisplayName("should start with speed 0")
        void shouldStartWithZeroSpeed() {
            Car ford = new Ford();
            assertEquals(0, ford.getSpeed());
        }

        @Test
        @DisplayName("should increase speed by 15")
        void shouldIncreaseSpeed() {
            Car ford = new Ford();
            ford.increaseSpeed();
            assertEquals(15, ford.getSpeed());
        }

        @Test
        @DisplayName("should increase speed twice to 30")
        void shouldIncreaseSpeedTwice() {
            Car ford = new Ford();
            ford.increaseSpeed();
            ford.increaseSpeed();
            assertEquals(30, ford.getSpeed());
        }

        @Test
        @DisplayName("should decrease speed by 10")
        void shouldDecreaseSpeed() {
            Car ford = new Ford();
            ford.increaseSpeed(); // 15
            ford.decreaseSpeed(); // 5
            assertEquals(5, ford.getSpeed());
        }

        @Test
        @DisplayName("should not go below zero when decreasing speed")
        void shouldNotGoBelowZero() {
            Car ford = new Ford();
            ford.decreaseSpeed();
            assertEquals(0, ford.getSpeed());
        }
    }

    @Nested
    @DisplayName("Opel tests")
    class OpelTests {

        @Test
        @DisplayName("should return name Opel")
        void shouldReturnName() {
            Car opel = new Opel();
            assertEquals("Opel", opel.getName());
        }

        @Test
        @DisplayName("should increase speed by 10")
        void shouldIncreaseSpeed() {
            Car opel = new Opel();
            opel.increaseSpeed();
            assertEquals(10, opel.getSpeed());
        }

        @Test
        @DisplayName("should decrease speed by 10")
        void shouldDecreaseSpeed() {
            Car opel = new Opel();
            opel.increaseSpeed(); // 10
            opel.increaseSpeed(); // 20
            opel.decreaseSpeed(); // 10
            assertEquals(10, opel.getSpeed());
        }

        @Test
        @DisplayName("should not go below zero when decreasing speed")
        void shouldNotGoBelowZero() {
            Car opel = new Opel();
            opel.decreaseSpeed();
            assertEquals(0, opel.getSpeed());
        }
    }

    @Nested
    @DisplayName("Toyota tests")
    class ToyotaTests {

        @Test
        @DisplayName("should return name Toyota")
        void shouldReturnName() {
            Car toyota = new Toyota();
            assertEquals("Toyota", toyota.getName());
        }

        @Test
        @DisplayName("should increase speed by 20")
        void shouldIncreaseSpeed() {
            Car toyota = new Toyota();
            toyota.increaseSpeed();
            assertEquals(20, toyota.getSpeed());
        }

        @Test
        @DisplayName("should decrease speed by 15")
        void shouldDecreaseSpeed() {
            Car toyota = new Toyota();
            toyota.increaseSpeed(); // 20
            toyota.decreaseSpeed(); // 5
            assertEquals(5, toyota.getSpeed());
        }

        @Test
        @DisplayName("should not go below zero when decreasing speed")
        void shouldNotGoBelowZero() {
            Car toyota = new Toyota();
            toyota.decreaseSpeed();
            assertEquals(0, toyota.getSpeed());
        }

        @Test
        @DisplayName("should not go below zero after small increase then large decrease")
        void shouldClampToZeroAfterSmallIncreaseThenDecrease() {
            Car toyota = new Toyota();
            toyota.increaseSpeed(); // 20
            toyota.decreaseSpeed(); // 5
            toyota.decreaseSpeed(); // 0 (clamped)
            assertEquals(0, toyota.getSpeed());
        }
    }
}
