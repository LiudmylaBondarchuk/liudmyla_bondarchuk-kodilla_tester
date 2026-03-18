package com.kodilla;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LeapYear Test Suite")
class LeapYearTestSuite {

    @DisplayName("year 2000 should be a leap year (divisible by 400)")
    @Test
    void testYear2000IsLeapYear() {
        assertTrue(LeapYear.isLeapYear(2000));
    }

    @DisplayName("year 1900 should not be a leap year (divisible by 100 but not 400)")
    @Test
    void testYear1900IsNotLeapYear() {
        assertFalse(LeapYear.isLeapYear(1900));
    }

    @DisplayName("year 2024 should be a leap year (divisible by 4 but not 100)")
    @Test
    void testYear2024IsLeapYear() {
        assertTrue(LeapYear.isLeapYear(2024));
    }

    @DisplayName("year 2023 should not be a leap year (not divisible by 4)")
    @Test
    void testYear2023IsNotLeapYear() {
        assertFalse(LeapYear.isLeapYear(2023));
    }

    @DisplayName("year 1600 should be a leap year (divisible by 400)")
    @Test
    void testYear1600IsLeapYear() {
        assertTrue(LeapYear.isLeapYear(1600));
    }

    @DisplayName("year 1800 should not be a leap year (divisible by 100 but not 400)")
    @Test
    void testYear1800IsNotLeapYear() {
        assertFalse(LeapYear.isLeapYear(1800));
    }
}
