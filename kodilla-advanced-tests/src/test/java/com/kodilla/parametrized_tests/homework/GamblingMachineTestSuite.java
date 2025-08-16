package com.kodilla.parametrized_tests.homework;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GamblingMachineTestSuite {

    private GamblingMachine gamblingMachine;

    @BeforeEach
    void setup() {
        gamblingMachine = new GamblingMachine();
    }

    @ParameterizedTest(name = "[{index}] valid numbers: {0},{1},{2},{3},{4},{5}")
    @CsvFileSource(resources = "/valid_numbers.csv", numLinesToSkip = 1)
    @DisplayName("For a valid set of 6 numbers, the result is in range 0..6 and no exception is thrown")
    void shouldReturnWinsInRangeForValidNumbers(int n1, int n2, int n3, int n4, int n5, int n6) throws InvalidNumbersException {
        Set<Integer> user = Set.of(n1, n2, n3, n4, n5, n6);

        int wins = gamblingMachine.howManyWins(user);

        assertTrue(wins >= 0 && wins <= 6,
                "The number of wins should be in range 0..6, but was: " + wins);
    }

    @ParameterizedTest(name = "[{index}] out of range: {0},{1},{2},{3},{4},{5}")
    @CsvFileSource(resources = "/invalid_scope_numbers.csv", numLinesToSkip = 1)
    @DisplayName("If at least one number is out of the 1..49 range, InvalidNumbersException is thrown")
    void shouldThrowWhenNumberOutOfScope(int n1, int n2, int n3, int n4, int n5, int n6) {
        Set<Integer> user = new HashSet<>(Arrays.asList(n1, n2, n3, n4, n5, n6));

        assertThrows(InvalidNumbersException.class,
                () -> gamblingMachine.howManyWins(user));
    }

    @ParameterizedTest(name = "[{index}] with duplicates (size < 6): {0},{1},{2},{3},{4},{5}")
    @CsvFileSource(resources = "/invalid_size_via_duplicates.csv", numLinesToSkip = 1)
    @DisplayName("If the set size is not 6 after removing duplicates, InvalidNumbersException is thrown")
    void shouldThrowWhenSizeIsNotSix(int n1, int n2, int n3, int n4, int n5, int n6) {
        Set<Integer> user = new HashSet<>(Arrays.asList(n1, n2, n3, n4, n5, n6));

        assertThrows(InvalidNumbersException.class,
                () -> gamblingMachine.howManyWins(user));
    }
}