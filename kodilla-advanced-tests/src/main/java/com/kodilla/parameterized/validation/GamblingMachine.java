package com.kodilla.parameterized.validation;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GamblingMachine {

    private static final int NUMBERS_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 49;

    private final Random random;

    public GamblingMachine() {
        this(new Random());
    }

    GamblingMachine(Random random) {
        this.random = random;
    }

    public int howManyWins(Set<Integer> userNumbers) throws InvalidNumbersException {
        validateNumbers(userNumbers);
        Set<Integer> computerNumbers = generateComputerNumbers();
        int wins = 0;
        for (Integer number : userNumbers) {
            if (computerNumbers.contains(number)) {
                wins++;
            }
        }
        return wins;
    }

    private void validateNumbers(Set<Integer> numbers) throws InvalidNumbersException {
        if (numbers == null || numbers.size() != NUMBERS_COUNT) {
            throw new InvalidNumbersException(
                    "You must provide exactly " + NUMBERS_COUNT + " unique numbers.");
        }
        for (Integer number : numbers) {
            if (number == null || number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new InvalidNumbersException(
                        "Number " + number + " is out of range "
                                + MIN_NUMBER + "-" + MAX_NUMBER + ".");
            }
        }
    }

    private Set<Integer> generateComputerNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < NUMBERS_COUNT) {
            numbers.add(random.nextInt(MAX_NUMBER) + MIN_NUMBER);
        }
        return numbers;
    }
}
