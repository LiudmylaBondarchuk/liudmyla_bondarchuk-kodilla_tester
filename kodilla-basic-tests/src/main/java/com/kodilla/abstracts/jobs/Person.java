package com.kodilla.abstracts.jobs;

import java.util.Objects;

public class Person {
    private final String firstName;
    private final int age;
    private final Job job;

    public Person(String firstName, int age, Job job) {
        Objects.requireNonNull(firstName, "firstName must not be null");
        Objects.requireNonNull(job, "job must not be null");
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
