package com.kodilla.inheritance.homework;

public class Windows10 extends OperatingSystem {
    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("Starting Windows10");
    }

    @Override
    public void turnOff(){
        super.turnOff();
            System.out.println("Windows10 is shutting down..");
        }

        public Windows10 (int releaseYear){
            super(releaseYear);
            System.out.println("Windows10 released in:"+ releaseYear);
        }
    }

