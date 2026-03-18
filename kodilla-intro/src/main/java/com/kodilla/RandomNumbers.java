package com.kodilla;

import java.util.Random;

public class RandomNumbers {

    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;
    private boolean generated = false;

    public void generate() {
        Random random = new Random();
        int sum = 0;

        while (sum <= 5000) {
            int number = random.nextInt(31);
            sum += number;
            generated = true;

            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }
    }

    public int getMin() {
        if (!generated) {
            throw new IllegalStateException("generate() must be called first");
        }
        return min;
    }

    public int getMax() {
        if (!generated) {
            throw new IllegalStateException("generate() must be called first");
        }
        return max;
    }
}
