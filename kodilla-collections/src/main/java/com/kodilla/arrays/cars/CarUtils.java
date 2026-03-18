package com.kodilla.arrays.cars;
import com.kodilla.interfaces.cars.Car;
public class CarUtils {
    public static void describeCar(Car car) {
        System.out.println("-----------------------------");
        System.out.println("Car brand: " + car.getName());
        System.out.println("Car speed: " + car.getSpeed() + " km/h");
    }
}
