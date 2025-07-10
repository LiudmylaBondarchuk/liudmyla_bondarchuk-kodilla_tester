package com.kodilla.abstracts;

public class Application {

    public static void main(String[] args) {

        Dog dog = new Dog();
        AnimalProcessor processor = new AnimalProcessor();
        processor.process(dog);
    }
}

