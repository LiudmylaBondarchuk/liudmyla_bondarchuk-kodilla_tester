package com.kodilla;

enum Color {
    BLACK,
    WHITE,
    PINK,
    GREEN,
    RED,
    ORANGE,
    YELLOW,
    BLUE
}
public class ColorApplication {
    public static void main(String[] args) {
        Color myColor = UserDialogs.getColor();
            System.out.println("Your color:" + myColor);

    }
}
