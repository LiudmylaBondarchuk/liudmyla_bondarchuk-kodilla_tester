package com.kodilla;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Notebook Test Suite")
class NotebookTestSuite {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

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

    @DisplayName("should print cheap message for low price")
    @Test
    void shouldPrintCheapForLowPrice() {
        // given
        Notebook notebook = new Notebook(1000, 400, 2024);

        // when
        notebook.checkPrice();

        // then
        assertTrue(outContent.toString().contains("This notebook is cheap."));
    }

    @DisplayName("should print good price message for mid-range price")
    @Test
    void shouldPrintGoodPriceForMidRange() {
        // given
        Notebook notebook = new Notebook(1000, 800, 2024);

        // when
        notebook.checkPrice();

        // then
        assertTrue(outContent.toString().contains("The price is good."));
    }

    @DisplayName("should print expensive message for high price")
    @Test
    void shouldPrintExpensiveForHighPrice() {
        // given
        Notebook notebook = new Notebook(1000, 2000, 2024);

        // when
        notebook.checkPrice();

        // then
        assertTrue(outContent.toString().contains("This notebook is expensive."));
    }

    @DisplayName("should print light message for low weight")
    @Test
    void shouldPrintLightForLowWeight() {
        // given
        Notebook notebook = new Notebook(500, 1000, 2024);

        // when
        notebook.checkWeight();

        // then
        assertTrue(outContent.toString().contains("This notebook is light"));
    }

    @DisplayName("should print not too heavy for medium weight")
    @Test
    void shouldPrintNotTooHeavyForMediumWeight() {
        // given
        Notebook notebook = new Notebook(1500, 1000, 2024);

        // when
        notebook.checkWeight();

        // then
        assertTrue(outContent.toString().contains("This notebook is not too heavy"));
    }

    @DisplayName("should print very heavy for high weight")
    @Test
    void shouldPrintVeryHeavyForHighWeight() {
        // given
        Notebook notebook = new Notebook(3000, 1000, 2024);

        // when
        notebook.checkWeight();

        // then
        assertTrue(outContent.toString().contains("This notebook is very heavy"));
    }

    @DisplayName("should assess new premium notebook")
    @Test
    void shouldAssessNewPremiumNotebook() {
        // given
        Notebook notebook = new Notebook(1000, 3000, 2024);

        // when
        notebook.assessNotebookCondition();

        // then
        assertTrue(outContent.toString().contains("This is a new and premium notebook"));
    }

    @DisplayName("should assess new affordable notebook")
    @Test
    void shouldAssessNewAffordableNotebook() {
        // given
        Notebook notebook = new Notebook(1000, 1000, 2024);

        // when
        notebook.assessNotebookCondition();

        // then
        assertTrue(outContent.toString().contains("This is a new but affordable notebook"));
    }

    @DisplayName("should assess older notebook")
    @Test
    void shouldAssessOlderNotebook() {
        // given
        Notebook notebook = new Notebook(1000, 1000, 2020);

        // when
        notebook.assessNotebookCondition();

        // then
        assertTrue(outContent.toString().contains("This is an older but still valuable notebook."));
    }
}
