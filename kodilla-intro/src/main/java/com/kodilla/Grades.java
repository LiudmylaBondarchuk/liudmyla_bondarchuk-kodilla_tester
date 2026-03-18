package com.kodilla;

import java.util.ArrayList;
import java.util.List;

public class Grades {
    private List<Integer> grades;

    public Grades() {
        this.grades = new ArrayList<>();
    }

    public void add(int value) {
        grades.add(value);
    }

    public int getLast() {
        if (grades.isEmpty()) {
            return 0;
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
