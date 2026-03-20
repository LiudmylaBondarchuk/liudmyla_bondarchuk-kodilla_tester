package com.kodilla;

import java.util.Objects;

public class UserStatisticsApp {
    private final String name;
    private final int age;
    private final double height;

    public UserStatisticsApp(String name, int age, double height) {
        Objects.requireNonNull(name, "name must not be null");
        if (age < 0) throw new IllegalArgumentException("age must not be negative, got: " + age);
        if (height < 0) throw new IllegalArgumentException("height must not be negative, got: " + height);
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public void checkAgeAndHeight() {
        if (age > 30 && height > 160) {
            System.out.println("User is older than 30 and taller than 160cm");
        } else {
            System.out.println("User is 30 (or younger) or 160cm (or shorter)");
        }
    }
}
