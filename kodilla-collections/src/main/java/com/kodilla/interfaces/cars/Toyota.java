package com.kodilla.interfaces.cars;

public class Toyota implements Car{
    private int speed;

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void increaseSpeed() {
        speed += 20;

    }

    @Override
    public void decreaseSpeed() {
        speed = Math.max(0, speed - 15);

    }

    @Override
    public String getName() {
        return "Toyota";
    }
}
