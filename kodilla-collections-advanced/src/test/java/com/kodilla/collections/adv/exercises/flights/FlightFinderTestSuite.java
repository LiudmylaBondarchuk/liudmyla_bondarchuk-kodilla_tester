package com.kodilla.collections.adv.exercises.flights;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("FlightFinder test suite")
class FlightFinderTestSuite {

    @Test
    @DisplayName("should find flights departing from Warsaw")
    void testFindFlightsFrom() {
        // given
        FlightFinder flightFinder = new FlightFinder();

        // when
        List<Flight> flightsFromWarsaw = flightFinder.findFlightsFrom("Warsaw");

        // then
        assertEquals(2, flightsFromWarsaw.size());
        assertTrue(flightsFromWarsaw.stream().anyMatch(f -> f.getArrival().equals("London")));
        assertTrue(flightsFromWarsaw.stream().anyMatch(f -> f.getArrival().equals("Berlin")));
    }

    @Test
    @DisplayName("should find flights arriving in London")
    void testFindFlightsTo() {
        // given
        FlightFinder flightFinder = new FlightFinder();

        // when
        List<Flight> flightsToLondon = flightFinder.findFlightsTo("London");

        // then
        assertEquals(2, flightsToLondon.size());
        assertTrue(flightsToLondon.stream().anyMatch(f -> f.getDeparture().equals("Warsaw")));
        assertTrue(flightsToLondon.stream().anyMatch(f -> f.getDeparture().equals("Berlin")));
    }

    @Test
    @DisplayName("should return empty list when no flights from given city")
    void testFindFlightsFromNoResult() {
        // given
        FlightFinder flightFinder = new FlightFinder();

        // when
        List<Flight> flightsFromMadrid = flightFinder.findFlightsFrom("Madrid");

        // then
        assertTrue(flightsFromMadrid.isEmpty());
    }

    @Test
    @DisplayName("should return empty list when no flights to given city")
    void testFindFlightsToNoResult() {
        // given
        FlightFinder flightFinder = new FlightFinder();

        // when
        List<Flight> flightsToTokyo = flightFinder.findFlightsTo("Tokyo");

        // then
        assertTrue(flightsToTokyo.isEmpty());
    }
}
