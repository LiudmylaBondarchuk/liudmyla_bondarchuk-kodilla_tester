package com.kodilla.inheritance.os;

public class OperatingSystem {

    private final int releaseYear;

    public OperatingSystem(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void turnOn() {
        System.out.println("System is turning on...");
    }

    public void turnOff() {
        System.out.println("System is shutting down...");
    }
}
