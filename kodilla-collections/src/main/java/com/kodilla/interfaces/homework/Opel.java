package com.kodilla.interfaces.homework;

public class Opel implements Car {
    private int speed;

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void increaseSpeed() {
       speed +=10;

    }

    @Override
    public void decreaseSpeed() {
        speed -=10;

    }

    @Override
    public String getName() {
        return "Opel";
    }
}
