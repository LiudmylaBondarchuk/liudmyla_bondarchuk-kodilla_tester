package com.kodilla.school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTestSuite {


    @Test
    public void shouldCalculateCorrectAveragesIfValuesAreInRange() {
    Student student = new Student("Martin");
      student.addGeographyGrade(4);
      student.addGeographyGrade(4);
      student.addGeographyGrade(2);

      student.addHistoryGrade(1);
      student.addHistoryGrade(5);

    double geographyAverage = student.getGeographyAverage();
    double historyAverage = student.getHistoryAverage();
    double mathsAverage = student.getMathsAverage();
    double physicsAverage = student.getPhysicsAverage();

    assertEquals(3.33, geographyAverage, 0.01);
    assertEquals(3, historyAverage, 0.01);
    assertEquals(0, mathsAverage, 0.01);
    assertEquals(0, physicsAverage, 0.01);
}
    @Test
    public void shouldCalculateAveragesIfValuesAreOutsideRange() {
        Student student = new Student("Martin");
        student.addGeographyGrade(-2);
        student.addGeographyGrade(4);
        student.addGeographyGrade(8);

        student.addMathGrade(0);

        student.addPhysicsGrade(19);
        student.addPhysicsGrade(3);
        student.addPhysicsGrade(3);

        double geographyAverage = student.getGeographyAverage();
        double historyAverage = student.getHistoryAverage();
        double mathsAverage = student.getMathsAverage();
        double physicsAverage = student.getPhysicsAverage();

        assertEquals(4, geographyAverage, 0.01);
        assertEquals(0, historyAverage, 0.01);
        assertEquals(0, mathsAverage, 0.01);
        assertEquals(3, physicsAverage, 0.01);
    }

    @Test
    public void averageShouldBeZeroIfStudentDontHaveGrades() {
        Student student = new Student("Martin");
        assertEquals(0, student.getAverage(), 0.0001);
    }

    @Test
    public void shouldCalculateStudentAverage() {
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
        assertEquals(2.375, student.getAverage(), 0.001);
    }

}

