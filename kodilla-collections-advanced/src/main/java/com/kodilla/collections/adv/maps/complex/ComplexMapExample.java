package com.kodilla.collections.adv.maps.complex;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ComplexMapExample {
    public static void main(String[] args) {
        Map<Student, Grades> school = new HashMap<>();
        Student john = new Student("John", "Stevenson");
        Student jessie = new Student("Jessie", "Pinkman");
        Student bart = new Student("Bart", "Simpson");

        Grades johnGrades = new Grades(List.of(5.0, 4.0, 4.5, 5.0, 5.0));
        Grades jessieGrades = new Grades(List.of(2.5, 3.0, 2.0));
        Grades bartGrades = new Grades(List.of(4.0, 4.0, 4.0, 4.0, 5.0));

        school.put(john, johnGrades);
        school.put(jessie, jessieGrades);
        school.put(bart, bartGrades);

        System.out.println(school.get(john));

        for (Map.Entry<Student, Grades> studentEntry : school.entrySet()) {
            System.out.println(studentEntry.getKey().getFirstname() + ", average: "
                    + studentEntry.getValue().getAverage());
        }

    }
}