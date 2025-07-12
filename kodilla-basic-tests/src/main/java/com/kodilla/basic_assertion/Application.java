package com.kodilla.basic_assertion;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 8;
        int sumResult = calculator.sum(a, b);
        boolean isSumCorrect = ResultChecker.assertEquals(13, sumResult);
        if (isSumCorrect) {
            System.out.println("Metoda sum działa poprawnie dla liczb " + a + " i " + b);
        } else {
            System.out.println("Metoda sum nie działa poprawnie dla liczb " + a + " i " + b);
        }
        int subtractResult = calculator.subtract(a, b);
        boolean isSubtractCorrect = ResultChecker.assertEquals(-3, subtractResult, 0.1);
        if (isSubtractCorrect) {
            System.out.println("Metoda subtract działa poprawnie dla liczb "+ a + " i " + b);
        }else {
            System.out.println("Metoda subtract nie działa poprawnie dla liczb " + a + "i " + b);
        }

        double squareResult = calculator.square(a);
        boolean isSquareCorrect = ResultChecker.assertEquals(25, squareResult, 0.01);
        if (isSquareCorrect){
            System.out.println("Metoda square działa poprawnie dla liczby " + a);
        }else{
            System.out.println("Metoda square nie działa poprawnie dla liczby " + a);
        }
    }
}
