package com.kodilla.school;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("School Grades test suite")
class GradesTestSuite {

    private static final double DELTA = 0.01;

    @Test
    @DisplayName("should have zero length when empty")
    void shouldHaveZeroLength() {
        //given
        Grades grades = new Grades();
        //when
        List<Integer> values = grades.getValues();
        //then
        assertEquals(0, values.size());
    }

    @Test
    @DisplayName("should add two elements")
    void shouldAddTwoElementsToArray() {
        //given
        Grades grades = new Grades();
        //when
        grades.add(4);
        grades.add(2);
        List<Integer> values = grades.getValues();
        //then
        assertEquals(2, values.size());
        assertEquals(4, values.get(0));
        assertEquals(2, values.get(1));
    }

    @Test
    @DisplayName("should calculate average")
    void shouldCalculateAverage() {
        //given
        Grades grades = new Grades();
        //when
        grades.add(4);
        grades.add(2);
        grades.add(5);
        //then
        assertEquals(3.66, grades.getAverage(), DELTA);
    }
}
