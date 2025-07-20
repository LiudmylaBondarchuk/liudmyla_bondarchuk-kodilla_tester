package com.kodilla.arrays.homework;
import com.kodilla.interfaces.homework.Car;
import com.kodilla.interfaces.homework.Opel;
import com.kodilla.interfaces.homework.Ford;
import com.kodilla.interfaces.homework.Toyota;
import java.util.Random;

public class CarsApplication {
    private  static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int size = RANDOM.nextInt(16);
        Car[] cars = new Car[size];

        for(int i = 0; i < cars.length; i++){
            cars[i] = drawCar();
        }

        for (Car car : cars ){
            CarUtils.describeCar(car);
        }
    }
    public static Car drawCar(){
        int drawn = RANDOM.nextInt(3);
        Car car;

        if (drawn == 0)
            car = new Ford();
        else if (drawn == 1)
            car = new Opel();
        else
            car = new Toyota();

        int speedUps = RANDOM.nextInt(5) + 1;
        for (int i = 0; i < speedUps; i++) {
            car.increaseSpeed();
        }

        return car;
    }
}


