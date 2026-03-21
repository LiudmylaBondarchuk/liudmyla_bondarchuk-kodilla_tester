package com.kodilla.interfaces.cars;

public final class Opel implements Car {
    private int speed;

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void increaseSpeed() {
        speed += 10;
    }

    @Override
    public void decreaseSpeed() {
        speed = Math.max(0, speed - 10);
    }

    @Override
    public String getName() {
        return "Opel";
    }

    @Override
    public String toString() {
        return "Opel{speed=" + speed + "}";
    }
}
