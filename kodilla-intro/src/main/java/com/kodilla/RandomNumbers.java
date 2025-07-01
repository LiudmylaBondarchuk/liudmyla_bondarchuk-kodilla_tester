package com.kodilla;
import java.util.Random;
public class RandomNumbers {
    public int [] generateNumbers(){
        Random random = new Random();
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (sum <= 5000){
            int number = random.nextInt(31);
            sum += number;

            if (number < min) {
                min = number;
            }

            if (number > max){
                max = number;
            }
        }

        return new int [] {min, max};
    }
}
