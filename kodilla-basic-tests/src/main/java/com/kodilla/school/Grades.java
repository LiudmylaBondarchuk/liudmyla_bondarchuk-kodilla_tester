package com.kodilla.school;

import java.util.ArrayList;
import java.util.List;

public class Grades {
    private List<Integer> values;

    public Grades() {
        this.values = new ArrayList<>();
    }

    public void add(int value) {
        values.add(value);
    }

    public List<Integer> getValues() {
        return new ArrayList<>(values);
    }

    public int getSize() {
        return values.size();
    }

    public double getAverage() {
        if (values.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum / values.size();
    }
}
