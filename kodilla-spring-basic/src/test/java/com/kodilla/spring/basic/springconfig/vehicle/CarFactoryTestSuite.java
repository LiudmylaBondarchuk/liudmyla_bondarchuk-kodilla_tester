package com.kodilla.spring.basic.springconfig.vehicle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.time.LocalDateTime;
import java.time.Month;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("CarFactory Tests")
class CarFactoryTestSuite {
    @Test
    @DisplayName("should create car based on current season")
    void shouldCreateSeasonalCar() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        Car car = context.getBean(Car.class);
        assertNotNull(car);
        assertNotNull(car.getCarType());
        Month month = LocalDateTime.now().getMonth();
        switch (month) {
            case JUNE, JULY, AUGUST -> assertEquals("Cabrio", car.getCarType());
            case DECEMBER, JANUARY, FEBRUARY -> assertEquals("SUV", car.getCarType());
            default -> assertEquals("Sedan", car.getCarType());
        }
    }
}
