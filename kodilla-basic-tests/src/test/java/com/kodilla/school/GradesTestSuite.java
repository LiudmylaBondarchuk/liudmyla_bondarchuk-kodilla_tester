package com.kodilla.school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradesTestSuite {

    @Test
    public void shouldHaveZeroLength() {
        //given
        Grades grades = new Grades();
        //when
        int[] values = grades.getValues();
        //then
        assertEquals(0, values.length);
    }
    @Test
    public void shouldAddTwoElementsToArray() {
        //given
        Grades grades = new Grades();
        //when
        grades.add(4);
        grades.add(2);
        int[] values = grades.getValues();
        //then
        assertEquals(2, values.length);
        assertEquals(4, values[0]);
        assertEquals(2, values[1]);
    }

    @Test
    public void shouldCalculateAverage() {
        //given
        Grades grades = new Grades();
        //when
        grades.add(4);
        grades.add(2);
        grades.add(5);
        //then
        assertEquals(3.66, grades.getAverage(), 0.01);
    }
}