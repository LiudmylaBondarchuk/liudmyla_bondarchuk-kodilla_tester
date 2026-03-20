package com.kodilla.collections.adv.exercises.flights;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Flight test suite")
class FlightTestSuite {

    @Test
    @DisplayName("should create flight with valid departure and arrival")
    void testCreateFlight() {
        //given & when
        Flight flight = new Flight("Warsaw", "London");

        //then
        assertEquals("Warsaw", flight.getDeparture());
        assertEquals("London", flight.getArrival());
    }

    @Test
    @DisplayName("should throw NullPointerException when departure is null")
    void testNullDeparture() {
        //given & when & then
        assertThrows(NullPointerException.class, () -> new Flight(null, "London"));
    }

    @Test
    @DisplayName("should throw NullPointerException when arrival is null")
    void testNullArrival() {
        //given & when & then
        assertThrows(NullPointerException.class, () -> new Flight("Warsaw", null));
    }

    @Test
    @DisplayName("should be equal when departure and arrival match")
    void testEqualFlights() {
        //given
        Flight flight1 = new Flight("Warsaw", "London");
        Flight flight2 = new Flight("Warsaw", "London");

        //when & then
        assertEquals(flight1, flight2);
        assertEquals(flight1.hashCode(), flight2.hashCode());
    }

    @Test
    @DisplayName("should not be equal when departure differs")
    void testNotEqualDifferentDeparture() {
        //given
        Flight flight1 = new Flight("Warsaw", "London");
        Flight flight2 = new Flight("Berlin", "London");

        //when & then
        assertNotEquals(flight1, flight2);
    }

    @Test
    @DisplayName("should not be equal when arrival differs")
    void testNotEqualDifferentArrival() {
        //given
        Flight flight1 = new Flight("Warsaw", "London");
        Flight flight2 = new Flight("Warsaw", "Berlin");

        //when & then
        assertNotEquals(flight1, flight2);
    }

    @Test
    @DisplayName("should return readable toString")
    void testToString() {
        //given
        Flight flight = new Flight("Warsaw", "London");

        //when
        String result = flight.toString();

        //then
        assertTrue(result.contains("Warsaw"));
        assertTrue(result.contains("London"));
    }
}
