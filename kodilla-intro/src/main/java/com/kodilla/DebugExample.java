public class DebugExample {
    public static void main(String[] args) {
        int firstNumber = 76;
        int secondNumber = 20;

        if(firstNumber>secondNumber) {
            subtractAndDisplay(firstNumber, secondNumber);
            } else {
                sumAndDisplay(firstNumber, secondNumber);
            }
        }
        private static void sumAndDisplay(int a, int b) {
            int result = a + b;

            System.out.println(result);
        }

        private static void subtractAndDisplay(int a, int b) {
            int result = a - b;

            System.out.println(result);
    }
}

/*public class DebugExample {
    public static void main(String[] args) {
        int firstNumber = 76;
        int secondNumber = 20;

        if (firstNumber > secondNumber) {
            int result = firstNumber + secondNumber;
            System.out.println(result);
        } else if (firstNumber < secondNumber) {
            int result = firstNumber - secondNumber;
            System.out.println(result);
        }
    }
} */

