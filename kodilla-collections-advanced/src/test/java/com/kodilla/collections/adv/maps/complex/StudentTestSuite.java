package com.kodilla.collections.adv.maps.complex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Student test suite")
class StudentTestSuite {

    @Test
    @DisplayName("should create student with valid names")
    void testCreateStudent() {
        //given & when
        Student student = new Student("John", "Doe");

        //then
        assertEquals("John", student.getFirstname());
        assertEquals("Doe", student.getLastname());
    }

    @Test
    @DisplayName("should throw NullPointerException when firstname is null")
    void testNullFirstname() {
        //given & when & then
        assertThrows(NullPointerException.class, () -> new Student(null, "Doe"));
    }

    @Test
    @DisplayName("should throw NullPointerException when lastname is null")
    void testNullLastname() {
        //given & when & then
        assertThrows(NullPointerException.class, () -> new Student("John", null));
    }

    @Test
    @DisplayName("should be equal when names match")
    void testEqualStudents() {
        //given
        Student student1 = new Student("John", "Doe");
        Student student2 = new Student("John", "Doe");

        //when & then
        assertEquals(student1, student2);
        assertEquals(student1.hashCode(), student2.hashCode());
    }

    @Test
    @DisplayName("should not be equal when firstname differs")
    void testNotEqualDifferentFirstname() {
        //given
        Student student1 = new Student("John", "Doe");
        Student student2 = new Student("Jane", "Doe");

        //when & then
        assertNotEquals(student1, student2);
    }

    @Test
    @DisplayName("should not be equal when lastname differs")
    void testNotEqualDifferentLastname() {
        //given
        Student student1 = new Student("John", "Doe");
        Student student2 = new Student("John", "Smith");

        //when & then
        assertNotEquals(student1, student2);
    }

    @Test
    @DisplayName("should return readable toString")
    void testToString() {
        //given
        Student student = new Student("John", "Doe");

        //when
        String result = student.toString();

        //then
        assertTrue(result.contains("John"));
        assertTrue(result.contains("Doe"));
    }
}
