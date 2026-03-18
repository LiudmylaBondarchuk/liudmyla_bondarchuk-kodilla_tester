package com.kodilla.exception;

import java.util.Scanner;

public class UserDialogs {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getNumberOfRounds() {
        while (true) {
            System.out.println("Enter number of rounds");
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Wrong data. Enter only digits. Try again.");
            }
        }
    }
}
