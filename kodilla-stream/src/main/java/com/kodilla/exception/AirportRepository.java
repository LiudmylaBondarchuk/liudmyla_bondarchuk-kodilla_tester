package com.kodilla.exception;

import java.util.Arrays;
import java.util.List;

public class AirportRepository {

    private final List<String> airportsInUse = Arrays.asList(
            "Warsaw", "Berlin", "London", "Paris", "Madrid"
    );

    public void checkAirportInUse(String airportName) throws AirportNotFoundException {
        if (!airportsInUse.contains(airportName)) {
            throw new AirportNotFoundException("Airport " + airportName + " not found");
        }
    }

    public boolean isAirportInUse(String airportName) {
        return airportsInUse.contains(airportName);
    }
}
