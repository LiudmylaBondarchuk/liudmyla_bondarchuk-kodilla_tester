package com.kodilla.school;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private static final int MIN_GRADE = 1;
    private static final int MAX_GRADE = 6;

    private final String name;
    private final Map<String, Grades> subjects;

    public Student(String name) {
        this.name = name;
        this.subjects = new HashMap<>();
        subjects.put("maths", new Grades());
        subjects.put("physics", new Grades());
        subjects.put("geography", new Grades());
        subjects.put("history", new Grades());
    }

    private void addGrade(String subject, int grade) {
        Grades grades = subjects.get(subject);
        if (grades != null && grade >= MIN_GRADE && grade <= MAX_GRADE) {
            grades.add(grade);
        }
    }

    private double getSubjectAverage(String subject) {
        Grades grades = subjects.get(subject);
        return grades != null ? grades.getAverage() : 0.0;
    }

    public void addMathGrade(int grade) { addGrade("maths", grade); }
    public void addPhysicsGrade(int grade) { addGrade("physics", grade); }
    public void addGeographyGrade(int grade) { addGrade("geography", grade); }
    public void addHistoryGrade(int grade) { addGrade("history", grade); }

    public double getMathsAverage() { return getSubjectAverage("maths"); }
    public double getPhysicsAverage() { return getSubjectAverage("physics"); }
    public double getGeographyAverage() { return getSubjectAverage("geography"); }
    public double getHistoryAverage() { return getSubjectAverage("history"); }

    public double getAverage() {
        int totalGrades = 0;
        double totalSum = 0;
        for (Grades grades : subjects.values()) {
            for (int value : grades.getValues()) {
                totalSum += value;
                totalGrades++;
            }
        }
        return totalGrades == 0 ? 0.0 : totalSum / totalGrades;
    }
}
