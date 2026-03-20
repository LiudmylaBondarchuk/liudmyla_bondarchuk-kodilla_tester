package com.kodilla;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Grades {
    private final List<Integer> grades;

    public Grades() {
        this.grades = new ArrayList<>();
    }

    public void add(int value) {
        grades.add(value);
    }

    public int getLast() {
        if (grades.isEmpty()) {
            throw new NoSuchElementException("No grades available");
        }
        return grades.get(grades.size() - 1);
    }

    public double getAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }
}
