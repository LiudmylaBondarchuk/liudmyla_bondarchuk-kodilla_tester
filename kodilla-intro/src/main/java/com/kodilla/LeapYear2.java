public class LeapYear2{
    public static void main(String[] args) {
        int year = 2024;
        boolean leapYear = (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));

        System.out.println("Year: " + year);
        if (leapYear) {
            System.out.println("Leap year");
        } else {
            System.out.println("It isn’t a leap year");
        }

        int startYear = 1582;
        int firstLeapYear = 0;

        for (int currentYear = startYear; currentYear <= 2025; currentYear++) {
            if ((currentYear % 4 == 0 && currentYear % 100 != 0) || (currentYear % 400 == 0)) {
                firstLeapYear = currentYear;
                break;
            }
        }

        System.out.println("The first leap year is: " + firstLeapYear);
    }
}