package com.kodilla.collections.adv.maps.complex;

import java.util.ArrayList;
import java.util.List;

public class Grades {
    private final List<Double> grades;

    public Grades(List<Double> grades) {
        this.grades = new ArrayList<>(grades);
    }

    public double getAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    @Override
    public String toString() {
        return "Grades{" +
                "grades=" + grades +
                '}';
    }
}
