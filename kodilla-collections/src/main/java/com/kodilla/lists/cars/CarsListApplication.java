package com.kodilla.lists.cars;
import com.kodilla.interfaces.cars.Car;
import com.kodilla.arrays.cars.CarUtils;
import com.kodilla.interfaces.cars.Ford;
import com.kodilla.interfaces.cars.Opel;
import com.kodilla.interfaces.cars.Toyota;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CarsListApplication {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        Ford ford = new Ford();

        cars.add(ford);
        cars.add(new Ford());
        cars.add(new Opel());
        cars.add(new Toyota());

        System.out.println("Collection content before removals:");
        for (Car car : cars) {
            CarUtils.describeCar(car);
        }

            cars.remove(1);
            cars.remove(ford);

            System.out.println("Collection content after removals:");
            for (Car car : cars) {
                CarUtils.describeCar(car);
            }
                System.out.println("Current collection size: " + cars.size());
            }
        }
