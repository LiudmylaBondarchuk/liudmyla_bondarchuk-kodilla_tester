package com.kodilla.collections.sets.homework;
import java.util.HashSet;
import java.util.Set;

public class StampsApplication {
    public static void main(String[] args) {
        Set<Stamp> stamps = new HashSet<>();
        stamps.add(new Stamp("Warsaw 2021", 2.0, 3.0, true));
        stamps.add(new Stamp("Gdańsk 2019", 1.5, 2.5, false));
        stamps.add(new Stamp("London 1999", 2.0, 3.0, true));
        stamps.add(new Stamp("Warsaw 2021", 2.0, 3.0, true));
        System.out.println(stamps.size());
        for (Stamp stamp : stamps) {
            System.out.println(stamp);
        }
    }
}
