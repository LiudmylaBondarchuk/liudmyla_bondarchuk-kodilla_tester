package com.kodilla.abstracts.shapes;

public class Person {
    private final String firstName;
    private final int age;
    private final Job job;

    public Person(String firstName, int age, Job job){
        this.firstName = firstName;
        this.age = age;
        this.job = job;
    }

    public void showResponsibilities() {
        System.out.println("Name: " + firstName + ", Age: " + age);
        System.out.println("Responsibilities: " + job.getResponsibilities());
        System.out.println();
    }
}

