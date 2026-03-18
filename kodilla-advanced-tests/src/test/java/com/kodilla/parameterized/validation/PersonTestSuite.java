package com.kodilla.parameterized.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Person BMI Tests")
class PersonTestSuite {

    @ParameterizedTest
    @CsvFileSource(resources = "/bmi_test_data.csv", numLinesToSkip = 1)
    @DisplayName("should return correct BMI category")
    void shouldReturnCorrectBMI(double height, double weight, String expectedBMI) {
        Person person = new Person(height, weight);
        assertEquals(expectedBMI, person.getBMI());
    }

    @Test
    @DisplayName("should throw exception when height is zero")
    void shouldThrowWhenHeightIsZero() {
        assertThrows(IllegalArgumentException.class, () -> new Person(0, 70));
    }

    @Test
    @DisplayName("should throw exception when height is negative")
    void shouldThrowWhenHeightIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Person(-1.7, 70));
    }

    @Test
    @DisplayName("should throw exception when weight is negative")
    void shouldThrowWhenWeightIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Person(1.7, -50));
    }

    @Test
    @DisplayName("should return Severely underweight for BMI ~15.5")
    void shouldReturnSeverelyUnderweight() {
        Person person = new Person(1.80, 50);
        assertEquals("Severely underweight", person.getBMI());
    }

    @Test
    @DisplayName("should return Underweight for BMI ~17")
    void shouldReturnUnderweight() {
        Person person = new Person(1.80, 55);
        assertEquals("Underweight", person.getBMI());
    }

    @Test
    @DisplayName("should return Overweight for BMI ~27")
    void shouldReturnOverweight() {
        Person person = new Person(1.75, 83);
        assertEquals("Overweight", person.getBMI());
    }

    @Test
    @DisplayName("should return Obese Class III for BMI ~42")
    void shouldReturnObeseClassIII() {
        Person person = new Person(1.70, 122);
        assertEquals("Obese Class III (Very severely obese)", person.getBMI());
    }

    @Test
    @DisplayName("should return Obese Class IV for BMI ~47")
    void shouldReturnObeseClassIV() {
        Person person = new Person(1.70, 136);
        assertEquals("Obese Class IV (Morbidly obese)", person.getBMI());
    }

    @Test
    @DisplayName("should return Obese Class V for BMI ~55")
    void shouldReturnObeseClassV() {
        Person person = new Person(1.70, 159);
        assertEquals("Obese Class V (Super obese)", person.getBMI());
    }
}
