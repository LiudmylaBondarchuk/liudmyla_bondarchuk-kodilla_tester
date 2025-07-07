package com.kodilla;
enum KodillaCourse {
    JD,  /* Java Developer */
    JDP, /* Java Developer Plus */
    TA,  /* Tester Automatyzujący */
    TAI  /* Tester Automatyzujący z egzaminem ISTQB */
}
public class MyCourseClass {
    public static void main(String[] args) {
        KodillaCourse myCourse = KodillaCourse.TA;
        switch (myCourse) {
            case JD -> System.out.println("Java Developer");
            case JDP -> System.out.println("Java Developer Plus");
            case TA -> System.out.println("Tester Automat.");
            case TAI -> System.out.println("Tester Automat. z ISTQB");
        }
    }
}
