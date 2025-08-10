package com.kodilla.com.optional.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Julia", new Teacher("Dr. Anna")));
        students.add(new Student("Laura", null));
        students.add(new Student("Adam", new Teacher("Dr. Maria")));
        students.add(new Student("Daniel", null));
        students.add(new Student("Diana", new Teacher("Dr. Martin")));
        students.add(new Student("Ewa", null));
        students.add(new Student("Max", new Teacher("Prof. Robert")));
        students.add(new Student("Alex", null));

        for (Student student : students) {
            String teacherName = Optional.ofNullable(student.getTeacher())
                    .map(Teacher::getName)
                    .orElse("<undefined>");
            System.out.println("Student: " + student.getName() + ", Wykładowca: " + teacherName);
        }
    }
}


