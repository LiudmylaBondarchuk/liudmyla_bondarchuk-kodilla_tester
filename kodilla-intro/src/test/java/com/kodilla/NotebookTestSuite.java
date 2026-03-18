package com.kodilla;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Notebook Test Suite")
class NotebookTestSuite {

    @DisplayName("should return correct weight from getter")
    @Test
    void testGetWeight() {
        // given
        Notebook notebook = new Notebook(1500.0, 3000.0, 2024);

        // when & then
        assertEquals(1500.0, notebook.getWeight(), 0.001);
    }

    @DisplayName("should return correct price from getter")
    @Test
    void testGetPrice() {
        // given
        Notebook notebook = new Notebook(1500.0, 3000.0, 2024);

        // when & then
        assertEquals(3000.0, notebook.getPrice(), 0.001);
    }

    @DisplayName("should return correct year from getter")
    @Test
    void testGetYear() {
        // given
        Notebook notebook = new Notebook(1500.0, 3000.0, 2024);

        // when & then
        assertEquals(2024, notebook.getYear());
    }

    @DisplayName("should store constructor values correctly")
    @Test
    void testConstructorStoresAllValues() {
        // given
        double weight = 800.0;
        double price = 500.0;
        int year = 2020;

        // when
        Notebook notebook = new Notebook(weight, price, year);

        // then
        assertAll(
                () -> assertEquals(weight, notebook.getWeight(), 0.001),
                () -> assertEquals(price, notebook.getPrice(), 0.001),
                () -> assertEquals(year, notebook.getYear())
        );
    }
}
