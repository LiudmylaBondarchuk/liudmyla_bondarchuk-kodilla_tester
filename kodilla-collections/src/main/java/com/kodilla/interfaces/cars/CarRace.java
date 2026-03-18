package com.kodilla.interfaces.cars;

public class CarRace {
    public static void main(String[] args) {
    Ford ford = new Ford();
    Opel opel = new Opel();
    Toyota toyota = new Toyota();
        doRace(ford);
        doRace(opel);
        doRace(toyota);
    }

    public static  void doRace(Car car){
        for (int i = 0; i < 3; i++) {
            car.increaseSpeed();
        }
        for (int i = 0; i < 2; i++) {
            car.decreaseSpeed();
        }
        System.out.println(car.getName() + " – Final speed: " + car.getSpeed() + " km/h");
    }
}
