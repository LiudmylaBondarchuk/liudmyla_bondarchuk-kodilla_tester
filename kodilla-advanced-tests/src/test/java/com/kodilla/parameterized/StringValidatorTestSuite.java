package com.kodilla.parameterized;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("StringValidator Tests")
class StringValidatorTestSuite {

    private StringValidator validator = new StringValidator();

    @ParameterizedTest
    @ValueSource(strings = {"test", "XyZ"})
    void shouldReturnFalseIfStringIsNotEmpty(String text) {
        assertFalse(validator.isBlank(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void shouldReturnTrueIfStringIsEmptyOrSpaces(String text) {
        assertTrue(validator.isBlank(text));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldReturnTrueIfStringIsNullOrEmpty(String text) {
        assertTrue(validator.isBlank(text));
    }
}