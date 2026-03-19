package com.kodilla.school;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Student test suite")
class StudentTestSuite {

    private static final double DELTA = 0.01;

    @Test
    @DisplayName("should calculate correct averages for in-range values")
    void shouldCalculateCorrectAveragesIfValuesAreInRange() {
        Student student = new Student("Martin");
        student.addGeographyGrade(4);
        student.addGeographyGrade(4);
        student.addGeographyGrade(2);

        student.addHistoryGrade(1);
        student.addHistoryGrade(5);

        assertEquals(3.33, student.getGeographyAverage(), DELTA);
        assertEquals(3.0, student.getHistoryAverage(), DELTA);
        assertEquals(0.0, student.getMathsAverage(), DELTA);
        assertEquals(0.0, student.getPhysicsAverage(), DELTA);
    }

    @Test
    @DisplayName("should filter out-of-range grades")
    void shouldCalculateAveragesIfValuesAreOutsideRange() {
        Student student = new Student("Martin");
        student.addGeographyGrade(-2);
        student.addGeographyGrade(4);
        student.addGeographyGrade(8);

        student.addMathGrade(0);

        student.addPhysicsGrade(19);
        student.addPhysicsGrade(3);
        student.addPhysicsGrade(3);

        assertEquals(4.0, student.getGeographyAverage(), DELTA);
        assertEquals(0.0, student.getHistoryAverage(), DELTA);
        assertEquals(0.0, student.getMathsAverage(), DELTA);
        assertEquals(3.0, student.getPhysicsAverage(), DELTA);
    }

    @Test
    @DisplayName("should return zero average when student has no grades")
    void averageShouldBeZeroIfStudentDontHaveGrades() {
        Student student = new Student("Martin");
        assertEquals(0.0, student.getAverage(), DELTA);
    }

    @Test
    @DisplayName("should calculate overall student average")
    void shouldCalculateStudentAverage() {
        Student student = new Student("Martin");
        student.addGeographyGrade(4);
        student.addGeographyGrade(4);
        student.addGeographyGrade(2);
        student.addGeographyGrade(-2);
        student.addGeographyGrade(4);
        student.addGeographyGrade(8);

        student.addHistoryGrade(1);
        student.addHistoryGrade(5);

        student.addMathGrade(0);

        student.addPhysicsGrade(19);
        student.addPhysicsGrade(3);
        student.addPhysicsGrade(3);
        assertEquals(3.25, student.getAverage(), DELTA);
    }
}
