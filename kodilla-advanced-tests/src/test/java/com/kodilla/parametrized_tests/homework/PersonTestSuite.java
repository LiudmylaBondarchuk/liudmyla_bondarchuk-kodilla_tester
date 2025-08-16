package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTestSuite {

    @ParameterizedTest
    @CsvFileSource(resources = "/bmi_test_data.csv", numLinesToSkip = 1)
    public void shouldReturnCorrectBMI(double height, double weight, String expectedBMI) {
        Person person = new Person(height, weight);
        assertEquals(expectedBMI, person.getBMI());
    }
}
