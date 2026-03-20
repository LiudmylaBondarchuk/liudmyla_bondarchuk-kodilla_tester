package com.kodilla.exception;

import java.util.Arrays;
import java.util.List;

public class AirportRepository {

    private final List<String> airportsInUse = Arrays.asList(
            "Warsaw", "Berlin", "London", "Paris", "Madrid"
    );

    public void checkAirportInUse(String airportName) throws AirportNotFoundException {
        if (airportName == null) {
            throw new IllegalArgumentException("airportName must not be null");
        }
        if (!airportsInUse.contains(airportName)) {
            throw new AirportNotFoundException("Airport " + airportName + " not found");
        }
    }

    public boolean isAirportInUse(String airportName) {
        if (airportName == null) {
            throw new IllegalArgumentException("airportName must not be null");
        }
        return airportsInUse.contains(airportName);
    }
}
