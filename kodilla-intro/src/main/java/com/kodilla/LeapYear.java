public class LeapYear {
    public static void main(String[] args) {
        int year = 2025;
        boolean leapYear = false;

        if (year % 400 == 0) {
            leapYear = true;
        } else if (year % 100 == 0) {
            leapYear = false;
        } else if (year % 4 == 0 && year % 100 != 0) {
            leapYear = true;
        } else {
             leapYear = false;
        }

        System.out.println(year);
        if ( leapYear == true) {
            System.out.println("Leap year");
        } else {
            System.out.println("It isn`t a leap year");
        }
    }
}