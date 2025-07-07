package com.kodilla;
public class Grades {
    private int []  grades;
    private int size;

    public Grades() {
        this.grades = new int[10];
        this.size = 0;
    }

    public void add(int value) {
        if (this.size == 10) {
            return;
        }
        this.grades[this.size] = value;
        this.size++;
    }

    public int getLast(){

        if (this.size == 0) {
            return 0;
        }
        return grades[size - 1];
    }


    public double getAverage() {
        if (size == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += grades[i];
        }
        return (double) sum / size;
    }
}