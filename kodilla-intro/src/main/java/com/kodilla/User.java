package com.kodilla;

import java.util.Objects;

public class User {
    private final String name;
    private final int age;

    public User(String name, int age) {
        Objects.requireNonNull(name, "name must not be null");
        if (age < 0) {
            throw new IllegalArgumentException("age must not be negative");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
