package com.kodilla.collections.adv.immutable.homework;

public class TaskApp {
    public static void main(String[] args) {
        Task task = new Task("Write report", 5);
        System.out.println("Task: " + task.title() + ", duration: " + task.duration() + " hours");
    }
}