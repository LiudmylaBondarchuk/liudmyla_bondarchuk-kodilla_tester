package com.kodilla.collections.adv.maps.complex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Grades test suite")
class GradesTestSuite {

    private static final double DELTA = 0.001;

    @Test
    @DisplayName("should calculate average of multiple grades")
    void testGetAverage() {
        //given
        Grades grades = new Grades(List.of(5.0, 4.0, 3.0));

        //when
        double average = grades.getAverage();

        //then
        assertEquals(4.0, average, DELTA);
    }

    @Test
    @DisplayName("should return zero average for empty grades list")
    void testGetAverageEmptyList() {
        //given
        Grades grades = new Grades(List.of());

        //when
        double average = grades.getAverage();

        //then
        assertEquals(0.0, average, DELTA);
    }

    @Test
    @DisplayName("should calculate average of single grade")
    void testGetAverageSingleGrade() {
        //given
        Grades grades = new Grades(List.of(4.5));

        //when
        double average = grades.getAverage();

        //then
        assertEquals(4.5, average, DELTA);
    }

    @Test
    @DisplayName("should make defensive copy of input list")
    void testDefensiveCopy() {
        //given
        List<Double> input = new ArrayList<>(List.of(5.0, 4.0, 3.0));
        Grades grades = new Grades(input);

        //when
        input.add(1.0);

        //then
        assertEquals(4.0, grades.getAverage(), DELTA);
    }

    @Test
    @DisplayName("should be equal when grades lists match")
    void testEqualGrades() {
        //given
        Grades grades1 = new Grades(List.of(5.0, 4.0));
        Grades grades2 = new Grades(List.of(5.0, 4.0));

        //when & then
        assertEquals(grades1, grades2);
        assertEquals(grades1.hashCode(), grades2.hashCode());
    }

    @Test
    @DisplayName("should not be equal when grades differ")
    void testNotEqualGrades() {
        //given
        Grades grades1 = new Grades(List.of(5.0, 4.0));
        Grades grades2 = new Grades(List.of(3.0, 2.0));

        //when & then
        assertNotEquals(grades1, grades2);
    }

    @Test
    @DisplayName("should return readable toString")
    void testToString() {
        //given
        Grades grades = new Grades(List.of(5.0, 4.0));

        //when
        String result = grades.toString();

        //then
        assertTrue(result.contains("5.0"));
        assertTrue(result.contains("4.0"));
    }
}
