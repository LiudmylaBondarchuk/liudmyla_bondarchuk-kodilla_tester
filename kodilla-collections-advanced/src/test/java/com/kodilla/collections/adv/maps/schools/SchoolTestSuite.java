package com.kodilla.collections.adv.maps.schools;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("School test suite")
class SchoolTestSuite {

    @Test
    @DisplayName("should create school with valid name and class sizes")
    void testCreateSchool() {
        //given & when
        School school = new School("Primary School", List.of(25, 28, 30));

        //then
        assertEquals("Primary School", school.getName());
    }

    @Test
    @DisplayName("should calculate total number of students")
    void testGetTotalStudents() {
        //given
        School school = new School("Primary School", List.of(25, 28, 30));

        //when
        int total = school.getTotalStudents();

        //then
        assertEquals(83, total);
    }

    @Test
    @DisplayName("should return zero total for empty class list")
    void testGetTotalStudentsEmptyList() {
        //given
        School school = new School("Empty School", List.of());

        //when
        int total = school.getTotalStudents();

        //then
        assertEquals(0, total);
    }

    @Test
    @DisplayName("should make defensive copy of class sizes list")
    void testDefensiveCopy() {
        //given
        List<Integer> classSizes = new ArrayList<>(List.of(25, 28, 30));
        School school = new School("Primary School", classSizes);

        //when
        classSizes.add(100);

        //then
        assertEquals(83, school.getTotalStudents());
    }

    @Test
    @DisplayName("should be equal when name and class sizes match")
    void testEqualSchools() {
        //given
        School school1 = new School("Primary School", List.of(25, 28));
        School school2 = new School("Primary School", List.of(25, 28));

        //when & then
        assertEquals(school1, school2);
        assertEquals(school1.hashCode(), school2.hashCode());
    }

    @Test
    @DisplayName("should not be equal when name differs")
    void testNotEqualDifferentName() {
        //given
        School school1 = new School("School A", List.of(25, 28));
        School school2 = new School("School B", List.of(25, 28));

        //when & then
        assertNotEquals(school1, school2);
    }

    @Test
    @DisplayName("should not be equal when class sizes differ")
    void testNotEqualDifferentClassSizes() {
        //given
        School school1 = new School("Primary School", List.of(25, 28));
        School school2 = new School("Primary School", List.of(30, 32));

        //when & then
        assertNotEquals(school1, school2);
    }

    @Test
    @DisplayName("should return readable toString")
    void testToString() {
        //given
        School school = new School("Primary School", List.of(25, 28));

        //when
        String result = school.toString();

        //then
        assertTrue(result.contains("Primary School"));
    }
}
