package com.kodilla;

public class LeapYear {

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        int year = 2025;

        System.out.println(year);
        if (isLeapYear(year)) {
            System.out.println("Leap year");
        } else {
            System.out.println("It isn't a leap year");
        }
    }
}
