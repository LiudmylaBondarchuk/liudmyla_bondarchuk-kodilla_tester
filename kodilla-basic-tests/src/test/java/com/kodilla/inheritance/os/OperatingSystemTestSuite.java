package com.kodilla.inheritance.os;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("OperatingSystem Inheritance Tests")
class OperatingSystemTestSuite {

    @Test
    @DisplayName("should store release year")
    void shouldStoreReleaseYear() {
        OperatingSystem os = new Windows10(2015);
        assertEquals(2015, os.getReleaseYear());
    }

    @Test
    @DisplayName("should store release year for MacOS")
    void shouldStoreReleaseYearForMacOS() {
        OperatingSystem os = new MacOSVentura(2022);
        assertEquals(2022, os.getReleaseYear());
    }

    @Test
    @DisplayName("Windows10 should be instance of OperatingSystem")
    void shouldBeInstanceOfOperatingSystem() {
        OperatingSystem os = new Windows10(2015);
        assertInstanceOf(OperatingSystem.class, os);
    }

    @Test
    @DisplayName("turnOn should not throw")
    void shouldTurnOnWithoutException() {
        OperatingSystem os = new Windows10(2015);
        assertDoesNotThrow(os::turnOn);
    }

    @Test
    @DisplayName("turnOff should not throw")
    void shouldTurnOffWithoutException() {
        OperatingSystem os = new MacOSVentura(2022);
        assertDoesNotThrow(os::turnOff);
    }
}
