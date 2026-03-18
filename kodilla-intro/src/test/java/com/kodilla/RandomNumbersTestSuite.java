package com.kodilla;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RandomNumbers Test Suite")
class RandomNumbersTestSuite {

    @DisplayName("should produce min in valid range [0, 30] after generate")
    @Test
    void testMinIsInValidRange() {
        // given
        RandomNumbers randomNumbers = new RandomNumbers();

        // when
        randomNumbers.generate();

        // then
        int min = randomNumbers.getMin();
        assertTrue(min >= 0 && min <= 30,
                "Min should be between 0 and 30, but was: " + min);
    }

    @DisplayName("should produce max in valid range [0, 30] after generate")
    @Test
    void testMaxIsInValidRange() {
        // given
        RandomNumbers randomNumbers = new RandomNumbers();

        // when
        randomNumbers.generate();

        // then
        int max = randomNumbers.getMax();
        assertTrue(max >= 0 && max <= 30,
                "Max should be between 0 and 30, but was: " + max);
    }

    @DisplayName("should have min less than or equal to max after generate")
    @Test
    void testMinIsLessThanOrEqualToMax() {
        // given
        RandomNumbers randomNumbers = new RandomNumbers();

        // when
        randomNumbers.generate();

        // then
        assertTrue(randomNumbers.getMin() <= randomNumbers.getMax(),
                "Min should be <= Max");
    }

    @DisplayName("should throw IllegalStateException when getMin called before generate")
    @Test
    void testGetMinThrowsBeforeGenerate() {
        // given
        RandomNumbers randomNumbers = new RandomNumbers();

        // when & then
        IllegalStateException exception = assertThrows(IllegalStateException.class,
                randomNumbers::getMin);
        assertEquals("generate() must be called first", exception.getMessage());
    }

    @DisplayName("should throw IllegalStateException when getMax called before generate")
    @Test
    void testGetMaxThrowsBeforeGenerate() {
        // given
        RandomNumbers randomNumbers = new RandomNumbers();

        // when & then
        IllegalStateException exception = assertThrows(IllegalStateException.class,
                randomNumbers::getMax);
        assertEquals("generate() must be called first", exception.getMessage());
    }
}
