package com.kodilla.cucumber.seasonchecker;

import java.time.MonthDay;
import java.util.Objects;

public class SeasonChecker {

    private static final MonthDay SUMMER_START = MonthDay.of(6, 20);
    private static final MonthDay SUMMER_END = MonthDay.of(9, 24);

    public static String checkIfSummer(MonthDay date) {
        Objects.requireNonNull(date, "date must not be null");
        return isDateInSummer(date) ? "Yes! Summer!" : "Nope";
    }

    private static boolean isDateInSummer(MonthDay date) {
        return !date.isBefore(SUMMER_START) && !date.isAfter(SUMMER_END);
    }
}
