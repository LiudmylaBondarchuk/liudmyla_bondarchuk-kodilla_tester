package com.kodilla.assertion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("PrimeChecker test suite")
class PrimeCheckerTestSuite {

    private final PrimeChecker checker = new PrimeChecker();

    @Test
    @DisplayName("should return false for a non-prime number")
    void shouldReturnFalseWhenPassingNotPrimeNumber() {
        assertFalse(checker.isPrime(14));
    }

    @Test
    @DisplayName("should return true for a prime number")
    void shouldReturnTrueWhenPassingPrimeNumber() {
        assertTrue(checker.isPrime(13));
    }

    @Test
    @DisplayName("should return true for 2")
    void shouldReturnTrueWhenPassingTwo() {
        assertTrue(checker.isPrime(2));
    }

    @Test
    @DisplayName("should return false for 1")
    void shouldReturnFalseWhenPassingOne() {
        assertFalse(checker.isPrime(1));
    }

    @Test
    @DisplayName("should return false for 0")
    void shouldReturnFalseWhenPassingZero() {
        assertFalse(checker.isPrime(0));
    }

    @Test
    @DisplayName("should return false for a negative number")
    void shouldReturnFalseWhenPassingNegativeNumber() {
        assertFalse(checker.isPrime(-6));
    }
}
