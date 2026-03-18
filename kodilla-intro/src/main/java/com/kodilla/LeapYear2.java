package com.kodilla;

public class LeapYear2 {
    public static void main(String[] args) {
        int year = 2024;

        System.out.println("Year: " + year);
        if (LeapYear.isLeapYear(year)) {
            System.out.println("Leap year");
        } else {
            System.out.println("It isn't a leap year");
        }

        int startYear = 1582;
        for (int currentYear = startYear; currentYear <= 2025; currentYear++) {
            if (LeapYear.isLeapYear(currentYear)) {
                System.out.println("The first leap year is: " + currentYear);
                break;
            }
        }
    }
}
