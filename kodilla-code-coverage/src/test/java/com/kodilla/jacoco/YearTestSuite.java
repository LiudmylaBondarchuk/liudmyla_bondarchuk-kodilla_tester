package com.kodilla.jacoco;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Year leap year test suite")
class YearTestSuite {

    @DisplayName("Should be leap year if divisible by 400")
    @Test
    void shouldBeLeapYearIfDivisibleBy400() {
        //given
        Year year = new Year(1600);

        //when
        boolean isLeapYear = year.isLeap();

        //then
        assertTrue(isLeapYear);
    }

    @DisplayName("Should not be leap year if divisible by 100 but not by 400")
    @Test
    void shouldNotBeLeapYearIfDivisibleBy100ButNotBy400() {
        //given
        Year year = new Year(1900);

        //when
        boolean isLeapYear = year.isLeap();

        //then
        assertFalse(isLeapYear);
    }

    @DisplayName("Should be leap year if divisible by 4 but not by 100")
    @Test
    void shouldBeLeapYearIfDivisibleBy4ButNotBy100() {
        //given
        Year year = new Year(2024);

        //when
        boolean isLeapYear = year.isLeap();

        //then
        assertTrue(isLeapYear);
    }

    @DisplayName("Should not be leap year if not divisible by 4")
    @Test
    void shouldNotBeLeapYearIfNotDivisibleBy4() {
        //given
        Year year = new Year(2023);

        //when
        boolean isLeapYear = year.isLeap();

        //then
        assertFalse(isLeapYear);
    }
}
