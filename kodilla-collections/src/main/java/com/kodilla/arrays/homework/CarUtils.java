package com.kodilla.arrays.homework;
import com.kodilla.interfaces.homework.Car;
public class CarUtils {
    public static void describeCar(Car car) {
        System.out.println("-----------------------------");
        System.out.println("Car brand: " + car.getName());
        System.out.println("Car speed: " + car.getSpeed() + " km/h");
    }
}
