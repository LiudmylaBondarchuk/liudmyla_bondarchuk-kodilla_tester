package com.kodilla;

import java.util.Random;

public class RandomNumbers {

    private static final int SUM_LIMIT = 5000;
    private static final int RANDOM_BOUND = 31;

    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;
    private boolean generated = false;

    public void generate() {
        Random random = new Random();
        int sum = 0;

        while (sum <= SUM_LIMIT) {
            int number = random.nextInt(RANDOM_BOUND);
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
