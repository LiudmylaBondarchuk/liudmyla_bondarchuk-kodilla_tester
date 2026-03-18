package com.kodilla.collections.adv.maps.schools;

import java.util.ArrayList;
import java.util.List;

public class School {
    private final String name;
    private final List<Integer> studentsInClasses;

    public School(String name, List<Integer> studentsInClasses) {
        this.name = name;
        this.studentsInClasses = new ArrayList<>(studentsInClasses);
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
