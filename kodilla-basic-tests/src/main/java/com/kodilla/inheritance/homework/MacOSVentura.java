package com.kodilla.inheritance.homework;

public class MacOSVentura extends OperatingSystem {

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("Starting MacOSVentura ");
    }

    @Override
    public void turnOff() {
        super.turnOff();
        System.out.println("MacOSVentura is shutting down...");
    }

    public MacOSVentura (int releaseYear){
        super(releaseYear);
        System.out.println("MacOSVentura released in: " + releaseYear );
    }
}
