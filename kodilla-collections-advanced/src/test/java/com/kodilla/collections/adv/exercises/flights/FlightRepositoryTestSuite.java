package com.kodilla.collections.adv.exercises.flights;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("FlightRepository test suite")
class FlightRepositoryTestSuite {

    @Test
    @DisplayName("should return non-empty list of flights")
    void testGetFlightsTableNotEmpty() {
        //given & when
        List<Flight> flights = FlightRepository.getFlightsTable();

        //then
        assertFalse(flights.isEmpty());
    }

    @Test
    @DisplayName("should return exactly 4 flights")
    void testGetFlightsTableSize() {
        //given & when
        List<Flight> flights = FlightRepository.getFlightsTable();

        //then
        assertEquals(4, flights.size());
    }

    @Test
    @DisplayName("should contain Warsaw-London flight")
    void testGetFlightsTableContainsWarsawLondon() {
        //given & when
        List<Flight> flights = FlightRepository.getFlightsTable();

        //then
        assertTrue(flights.contains(new Flight("Warsaw", "London")));
    }

    @Test
    @DisplayName("should return new list instance on each call")
    void testGetFlightsTableReturnsNewList() {
        //given & when
        List<Flight> flights1 = FlightRepository.getFlightsTable();
        List<Flight> flights2 = FlightRepository.getFlightsTable();

        //then
        assertNotSame(flights1, flights2);
        assertEquals(flights1, flights2);
    }
}
