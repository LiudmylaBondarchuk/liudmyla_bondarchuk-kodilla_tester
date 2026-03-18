package com.kodilla.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("AirportRepository Tests")
class AirportRepositoryTestSuite {

    @Test
    @DisplayName("should return true when airport is in use")
    void shouldReturnTrueWhenAirportIsInUse() {
        // given
        AirportRepository airportRepository = new AirportRepository();
        // when
        boolean isWarsawInUse = airportRepository.isAirportInUse("Warsaw");
        // then
        assertTrue(isWarsawInUse);
    }

    @Test
    @DisplayName("should return false when airport is not in use")
    void shouldReturnFalseWhenAirportIsNotInUse() {
        // given
        AirportRepository airportRepository = new AirportRepository();
        // when
        boolean isViennaInUse = airportRepository.isAirportInUse("Vienna");
        // then
        assertFalse(isViennaInUse);
    }

    @Test
    @DisplayName("should throw AirportNotFoundException when checking unknown airport")
    void shouldThrowExceptionWhenCheckingUnknownAirport() {
        // given
        AirportRepository airportRepository = new AirportRepository();
        // when & then
        assertThrows(AirportNotFoundException.class, () -> airportRepository.checkAirportInUse("Vienna"));
    }

    @Test
    @DisplayName("should not throw when checking known airport")
    void shouldNotThrowWhenCheckingKnownAirport() {
        // given
        AirportRepository airportRepository = new AirportRepository();
        // when & then
        assertDoesNotThrow(() -> airportRepository.checkAirportInUse("Warsaw"));
    }
}
