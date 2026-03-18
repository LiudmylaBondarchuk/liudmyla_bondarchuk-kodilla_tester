package com.kodilla.exception;

public class ThirdExample {
    public static void main(String[] args) {
        AirportRepository airportRepository = new AirportRepository();
        try {
            airportRepository.checkAirportInUse("Vienna");
            System.out.println("Vienna is in use.");
        } catch (AirportNotFoundException e) {
            System.out.println("Sorry, this airport cannot be found in our airlines.");
        } finally {
            System.out.println("Thank you for using Kodilla Airlines");
        }

        boolean warsawInUse = airportRepository.isAirportInUse("Warsaw");
        System.out.println("Warsaw in use: " + warsawInUse);
    }
}
