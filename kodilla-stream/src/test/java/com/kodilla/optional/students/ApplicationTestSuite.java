package com.kodilla.optional.students;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Optional Students test suite")
class ApplicationTestSuite {

    @Test
    @DisplayName("should return teacher name if present")
    void shouldReturnTeacherNameIfPresent() {
        Student student = new Student("Julia", new Teacher("Dr. Anna"));

        String teacherName = Optional.ofNullable(student.getTeacher())
                .map(Teacher::getName)
                .orElse("<undefined>");

        assertEquals("Dr. Anna", teacherName);
    }

    @Test
    @DisplayName("should return <undefined> if teacher is null")
    void shouldReturnUndefinedIfTeacherIsNull() {
        Student student = new Student("Laura", null);

        String teacherName = Optional.ofNullable(student.getTeacher())
                .map(Teacher::getName)
                .orElse("<undefined>");

        assertEquals("<undefined>", teacherName);
    }

    @Test
    @DisplayName("should process all students correctly")
    void shouldProcessAllStudents() {
        List<Student> students = Arrays.asList(
                new Student("Julia", new Teacher("Dr. Anna")),
                new Student("Laura", null),
                new Student("Adam", new Teacher("Dr. Maria"))
        );

        List<String> results = new ArrayList<>();
        for (Student student : students) {
            String teacherName = Optional.ofNullable(student.getTeacher())
                    .map(Teacher::getName)
                    .orElse("<undefined>");
            results.add("Student: " + student.getName()
                    + ", Wykładowca: " + teacherName);
        }

        assertEquals("Student: Julia, Wykładowca: Dr. Anna", results.get(0));
        assertEquals("Student: Laura, Wykładowca: <undefined>", results.get(1));
        assertEquals("Student: Adam, Wykładowca: Dr. Maria", results.get(2));
    }

    @Test
    @DisplayName("should throw when student name is null")
    void shouldThrowWhenStudentNameIsNull() {
        assertThrows(NullPointerException.class,
                () -> new Student(null, new Teacher("Dr. Kowalski")));
    }

    @Test
    @DisplayName("should handle empty student list")
    void shouldHandleEmptyStudentList() {
        List<Student> students = Collections.emptyList();

        List<String> results = new ArrayList<>();
        for (Student student : students) {
            String teacherName = Optional.ofNullable(student.getTeacher())
                    .map(Teacher::getName)
                    .orElse("<undefined>");
            results.add("Student: " + student.getName()
                    + ", Wykładowca: " + teacherName);
        }

        assertTrue(results.isEmpty());
    }
}
