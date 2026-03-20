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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }
}
