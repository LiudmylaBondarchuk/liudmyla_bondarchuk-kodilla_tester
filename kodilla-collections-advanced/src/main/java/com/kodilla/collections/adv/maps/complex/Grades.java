package com.kodilla.collections.adv.maps.complex;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grades that = (Grades) o;
        return Objects.equals(grades, that.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grades);
    }

    @Override
    public String toString() {
        return "Grades{" +
                "grades=" + grades +
                '}';
    }
}
