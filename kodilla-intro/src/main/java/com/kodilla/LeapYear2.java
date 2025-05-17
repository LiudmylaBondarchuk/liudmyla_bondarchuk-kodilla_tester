public class LeapYear2 {
    public static void main(String[] args) {
        int year = 2024;

        boolean LeapYear = (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));

        System.out.println(year);
        if (LeapYear == true) {
            System.out.println("Leap year");
        } else {
            System.out.println("It isn`t a leap year");
        }
    }
}
