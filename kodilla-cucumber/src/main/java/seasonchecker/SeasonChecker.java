package seasonchecker;

import java.time.MonthDay;

public class SeasonChecker {

    private static final MonthDay SUMMER_START = MonthDay.of(6, 20);
    private static final MonthDay SUMMER_END = MonthDay.of(9, 24);

    public static String checkIfSummer(MonthDay date) {
        return isDateInSummer(date) ? "Yes! Summer!" : "Nope";
    }

    private static boolean isDateInSummer(MonthDay date) {
        return date.isAfter(SUMMER_START) && date.isBefore(SUMMER_END);
    }
}
