package com.kodilla.collections.adv.exercises.homework;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FlightFinderTestSuite {

    @Test
    public void testFindFlightsFrom() {
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
    public void testFindFlightsTo() {
        //  given
        FlightFinder flightFinder = new FlightFinder();

        // when
        List<Flight> flightsToLondon = flightFinder.findFlightsTo("London");

        // then
        assertEquals(2, flightsToLondon.size());
        assertTrue(flightsToLondon.stream().anyMatch(f -> f.getDeparture().equals("Warsaw")));
        assertTrue(flightsToLondon.stream().anyMatch(f -> f.getDeparture().equals("Berlin")));
    }

    @Test
    public void testFindFlightsFromNoResult() {
        // given
        FlightFinder flightFinder = new FlightFinder();

        // when
        List<Flight> flightsFromMadrid = flightFinder.findFlightsFrom("Madrid");

        // then
        assertTrue(flightsFromMadrid.isEmpty());
    }

    @Test
    public void testFindFlightsToNoResult() {
        // given
        FlightFinder flightFinder = new FlightFinder();

        // when
        List<Flight> flightsToTokyo = flightFinder.findFlightsTo("Tokyo");

        // then
        assertTrue(flightsToTokyo.isEmpty());
    }
}
