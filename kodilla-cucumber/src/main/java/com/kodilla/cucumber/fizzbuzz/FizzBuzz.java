package com.kodilla.cucumber.fizzbuzz;

public class FizzBuzz {

    public static String check(int number) {
        if (number % 15 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return "None";
        }
    }
}
