package com.kodilla.abstracts.homework;

public class JobDemo {
    public static void main(String[] args) {

        Job businessAnalyst = new BusinessAnalyst();
        Job developer = new Developer();
        Job tester = new Tester();

        Person anna  = new Person( "Anna", 27, businessAnalyst);
        Person robert = new Person("Robert", 30, developer);
        Person adam  = new Person("Adam", 26, tester);

        anna.showResponsibilities();
        robert.showResponsibilities();
        adam.showResponsibilities();
    }
}
