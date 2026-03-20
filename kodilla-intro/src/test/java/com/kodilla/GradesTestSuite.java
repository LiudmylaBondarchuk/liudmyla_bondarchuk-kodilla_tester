package com.kodilla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Grades Test Suite")
class GradesTestSuite {

    private Grades grades;

    @BeforeEach
    void setUp() {
        grades = new Grades();
    }

    @DisplayName("should add grade and retrieve it as last")
    @Test
    void testAddAndGetLast() {
        // when
        grades.add(5);
        grades.add(3);

        // then
        assertEquals(3, grades.getLast());
    }

    @DisplayName("should return last added grade")
    @Test
    void testGetLastReturnsMostRecent() {
        // given
        grades.add(2);
        grades.add(4);
        grades.add(5);

        // when
        int last = grades.getLast();

        // then
        assertEquals(5, last);
    }

    @DisplayName("should throw NoSuchElementException when getting last from empty grades")
    @Test
    void testGetLastOnEmptyGrades() {
        // when & then
        assertThrows(NoSuchElementException.class, () -> grades.getLast());
    }

    @DisplayName("should calculate average correctly")
    @Test
    void testGetAverage() {
        // given
        grades.add(3);
        grades.add(4);
        grades.add(5);

        // when
        double average = grades.getAverage();

        // then
        assertEquals(4.0, average, 0.001);
    }

    @DisplayName("should return average for single grade")
    @Test
    void testGetAverageSingleGrade() {
        // given
        grades.add(5);

        // when
        double average = grades.getAverage();

        // then
        assertEquals(5.0, average, 0.001);
    }

    @DisplayName("should return zero average for empty grades")
    @Test
    void testGetAverageOnEmptyGrades() {
        // when
        double average = grades.getAverage();

        // then
        assertEquals(0.0, average, 0.001);
    }
}
