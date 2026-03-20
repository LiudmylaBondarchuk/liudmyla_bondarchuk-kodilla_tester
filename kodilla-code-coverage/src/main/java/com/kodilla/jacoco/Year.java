package com.kodilla.jacoco;

public class Year {

    private final int year;

    public Year(int year) {
        this.year = year;
    }

    public boolean isLeap() {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        if (year % 4 == 0) return true;
        return false;
    }
}
