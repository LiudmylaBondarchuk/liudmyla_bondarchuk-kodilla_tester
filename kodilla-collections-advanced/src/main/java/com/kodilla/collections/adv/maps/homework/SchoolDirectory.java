package com.kodilla.collections.adv.maps.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class SchoolDirectory {
    public static void main(String[] args) {
        Map<Principal, School> directory = new HashMap<>();

        Principal principal1 = new Principal("Anna", "Kowalska");
        Principal principal2 = new Principal("Jan", "Nowak");
        Principal principal3 = new Principal("Maria", "Wiśniewska");

        School school1 = new School("Szkoła Podstawowa nr 1", List.of(25, 28, 30, 27));
        School school2 = new School("Szkoła Podstawowa nr 2", List.of(22, 24, 26));
        School school3 = new School("Szkoła Podstawowa nr 3", List.of(20, 21, 23, 22, 24));

        directory.put(principal1, school1);
        directory.put(principal2, school2);
        directory.put(principal3, school3);

        for (Map.Entry<Principal, School> entry : directory.entrySet()) {
            Principal principal = entry.getKey();
            School school = entry.getValue();
            System.out.println("School principal: " + principal.getFirstname() + " " + principal.getLastname()
                    + ", school name: " + school.getName()
                    + ", total number of students: " + school.getTotalStudents());
        }
    }
}
