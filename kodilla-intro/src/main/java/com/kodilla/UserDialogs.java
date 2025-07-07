package com.kodilla;
import java.util.Scanner;
public class UserDialogs {
    public static String getUsername() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your name: ");
            String name = scanner.nextLine().trim();
            if (name.length() >= 2) {
                return name;
            }
            System.out.println("Name is too short. Try again.");
        }
    }

    public static String getUserSelection() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select calculation (A-add, S-subtract, D-divide, M-multiply):");
            String calc = scanner.nextLine().trim().toUpperCase();
            switch (calc) {
                case "A":
                    return "ADD";
                case "S":
                    return "SUB";
                case "D":
                    return "DIV";
                case "M":
                    return "MUL";
                default:
                    System.out.println("Wrong calculation. Try again.");
            }
        }
    }

    public static int getValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number:");
        int val = scanner.nextInt();
        return val;
    }

    public static Color getColor() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select color: B-BLACK, W-WHITE, " +
                    "P-PINK, G-GREEN, O-ORANGE, Y-YELLOW, BL- BLUE:");
            String input = scanner.nextLine().trim().toUpperCase();
            switch (input) {
                case "B":
                    return Color.BLACK;
                case "W":
                    return Color.WHITE;
                case "P":
                    return Color.PINK;
                case "G":
                    return Color.GREEN;
                case "O":
                    return Color.ORANGE;
                case "Y":
                    return Color.YELLOW;
                case "BL":
                    return Color.BLUE;
                default:
                    System.out.println("Invalid selection. Try again.");
            }
        }
    }
}
