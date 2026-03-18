package com.kodilla.parameterized.validation;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GamblingMachine {

    private final Random random = new Random();

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
        if (numbers == null || numbers.size() != 6) {
            throw new InvalidNumbersException("You must provide exactly 6 unique numbers.");
        }
        for (Integer number : numbers) {
            if (number == null || number < 1 || number > 49) {
                throw new InvalidNumbersException("Number " + number + " is out of range 1-49.");
            }
        }
    }

    private Set<Integer> generateComputerNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 6) {
            numbers.add(random.nextInt(49) + 1);
        }
        return numbers;
    }
}
