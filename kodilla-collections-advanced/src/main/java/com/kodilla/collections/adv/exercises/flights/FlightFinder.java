package com.kodilla.collections.adv.exercises.flights;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FlightFinder {

    public List<Flight> findFlightsFrom(String departure) {
        return findFlights(flight -> flight.getDeparture().equalsIgnoreCase(departure));
    }

    public List<Flight> findFlightsTo(String arrival) {
        return findFlights(flight -> flight.getArrival().equalsIgnoreCase(arrival));
    }

    private List<Flight> findFlights(Predicate<Flight> condition) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : FlightRepository.getFlightsTable()) {
            if (condition.test(flight)) {
                result.add(flight);
            }
        }
        return result;
    }
}
