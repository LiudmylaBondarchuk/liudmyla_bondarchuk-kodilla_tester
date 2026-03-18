package com.kodilla.school;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradesTestSuite {

    @Test
    public void shouldHaveZeroLength() {
        //given
        Grades grades = new Grades();
        //when
        List<Integer> values = grades.getValues();
        //then
        assertEquals(0, values.size());
    }

    @Test
    public void shouldAddTwoElementsToArray() {
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
