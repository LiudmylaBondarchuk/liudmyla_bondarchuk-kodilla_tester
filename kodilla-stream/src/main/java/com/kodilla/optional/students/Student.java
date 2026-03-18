package com.kodilla.optional.students;

import java.util.Objects;

public class Student {
    private final String name;
    private final Teacher teacher;

    public Student(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(teacher, student.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, teacher);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', teacher=" + teacher + '}';
    }
}
