package com.kodilla;

import java.util.Scanner;

public class UserDialogs {

    public static String getUserSelection() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select operation: ADD, SUB, DIV, MUL");
            String selection = scanner.nextLine().trim().toUpperCase();
            if (selection.equals("ADD") || selection.equals("SUB") || selection.equals("DIV") || selection.equals("MUL")) {
                return selection;
            }
            System.out.println("Wrong selection. Try again.");
        }
    }

    public static int getValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integer value:");
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }
}
