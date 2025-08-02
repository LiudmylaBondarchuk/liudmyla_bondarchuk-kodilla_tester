package com.kodilla.collections.adv.maps.homework;

import java.util.List;

public class School {
    private String name;
    private List<Integer> studentsInClasses;

    public School(String name, List<Integer> studentsInClasses) {
        this.name = name;
        this.studentsInClasses = studentsInClasses;
    }

    public String getName() {
        return name;
    }

    public int getTotalStudents() {
        int sum = 0;
        for (int students : studentsInClasses) {
            sum += students;
        }
        return sum;
    }
}
