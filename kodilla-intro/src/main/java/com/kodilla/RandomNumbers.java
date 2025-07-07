package com.kodilla;
import java.util.Random;
public class RandomNumbers {

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    public void generate() {
        Random random = new Random();
        int sum = 0;

        while (sum <= 5000) {
            int number = random.nextInt(31);
            sum += number;

            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }
    }
        public int getMin()
        {
                return min;

            }
        public int getMax()
        {
                return max;

            }
        }

