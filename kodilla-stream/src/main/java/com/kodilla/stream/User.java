package com.kodilla.stream;

import java.util.Objects;

public class User {
    private final String username;
    private final int age;
    private final int numberOfPost;
    private final String group;

    public User(String username, int age, int numberOfPost, String group) {
        Objects.requireNonNull(username, "username must not be null");
        Objects.requireNonNull(group, "group must not be null");
        if (age < 0) {
            throw new IllegalArgumentException("age must not be negative");
        }
        if (numberOfPost < 0) {
            throw new IllegalArgumentException(
                    "numberOfPost must not be negative");
        }
        this.username = username;
        this.age = age;
        this.numberOfPost = numberOfPost;
        this.group = group;
    }

    public String getUsername() {
        return username;
    }
    public int getAge() {
        return age;
    }
    public int getNumberOfPost() {
        return numberOfPost;
    }
    public String getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && numberOfPost == user.numberOfPost && Objects.equals(username, user.username) && Objects.equals(group, user.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, age, numberOfPost, group);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", numberOfPost=" + numberOfPost +
                ", group='" + group + '\'' +
                '}';
    }
}