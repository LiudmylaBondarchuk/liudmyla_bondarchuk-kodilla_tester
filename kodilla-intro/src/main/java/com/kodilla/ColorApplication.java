import java.util.Scanner;
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

    public static Color getColor() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select color: B-BLACK, W-WHITE, " +
                    "P-PINK, G-GREEN, R-RED, " +
                    "O-ORANGE, Y-YELLOW, BL-BLUE:");
            String input = scanner.nextLine().trim().toUpperCase();
            switch (input) {
                case "B": return Color.BLACK;
                case "W": return Color.WHITE;
                case "P": return Color.PINK;
                case "G": return Color.GREEN;
                case "R": return Color.RED;
                case "O": return Color.ORANGE;
                case "Y": return Color.YELLOW;
                case "BL": return Color.BLUE;
                default:
                    System.out.println("Invalid selection. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        Color myColor = getColor();
        System.out.println("Your color: " + myColor);
    }
}