package com.kodilla.com.optional.homework;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTestSuite {

    @Test
    void shouldReturnTeacherNameIfPresent() {
        // Given
        Student student = new Student("Julia", new Teacher("Dr. Anna"));

        // When
        String teacherName = Optional.ofNullable(student.getTeacher())
                .map(Teacher::getName)
                .orElse("<undefined>");

        // Then
        assertEquals("Dr. Anna", teacherName);
    }

    @Test
    void shouldReturnUndefinedIfTeacherIsNull() {
        // Given
        Student student = new Student("Laura", null);

        // When
        String teacherName = Optional.ofNullable(student.getTeacher())
                .map(Teacher::getName)
                .orElse("<undefined>");

        // Then
        assertEquals("<undefined>", teacherName);
    }

    @Test
    void shouldProcessAllStudents() {
        // Given
        List<Student> students = Arrays.asList(
                new Student("Julia", new Teacher("Dr. Anna")),
                new Student("Laura", null),
                new Student("Adam", new Teacher("Dr. Maria"))
        );

        // When
        List<String> results = new ArrayList<>();
        for (Student student : students) {
            String teacherName = Optional.ofNullable(student.getTeacher())
                    .map(Teacher::getName)
                    .orElse("<undefined>");
            results.add("Student: " + student.getName() + ", Wykładowca: " + teacherName);
        }

        // Then
        assertEquals("Student: Julia, Wykładowca: Dr. Anna", results.get(0));
        assertEquals("Student: Laura, Wykładowca: <undefined>", results.get(1));
        assertEquals("Student: Adam, Wykładowca: Dr. Maria", results.get(2));
    }

    @Test
    void shouldHandleStudentWithoutName() {
        // Given
        Student student = new Student(null, new Teacher("Dr. Kowalski"));

        // When
        String teacherName = Optional.ofNullable(student.getTeacher())
                .map(Teacher::getName)
                .orElse("<undefined>");

        // Then
        assertEquals("Dr. Kowalski", teacherName);
    }

    @Test
    void shouldHandleEmptyStudentList() {
        // Given
        List<Student> students = Collections.emptyList();

        // When
        List<String> results = new ArrayList<>();
        for (Student student : students) {
            String teacherName = Optional.ofNullable(student.getTeacher())
                    .map(Teacher::getName)
                    .orElse("<undefined>");
            results.add("Student: " + student.getName() + ", Wykładowca: " + teacherName);
        }

        // Then
        assertTrue(results.isEmpty());
    }
}
