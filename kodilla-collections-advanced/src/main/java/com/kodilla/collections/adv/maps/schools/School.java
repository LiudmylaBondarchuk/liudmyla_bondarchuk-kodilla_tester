package com.kodilla.collections.adv.maps.schools;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class School {
    private final String name;
    private final List<Integer> studentsInClasses;

    public School(String name, List<Integer> studentsInClasses) {
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(studentsInClasses, "studentsInClasses must not be null");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(name, school.name)
                && Objects.equals(studentsInClasses, school.studentsInClasses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, studentsInClasses);
    }

    @Override
    public String toString() {
        return "School{name='" + name + "', studentsInClasses=" + studentsInClasses + "}";
    }
}
