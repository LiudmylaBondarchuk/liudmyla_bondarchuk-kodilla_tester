package com.kodilla.spring.basic.springconfig.vehicle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Month;

@Configuration
public class CarFactory {

    @Bean
    public Clock systemClock() {
        return Clock.systemDefaultZone();
    }

    @Bean
    public Car seasonCar(Clock systemClock) {
        boolean headlightsOn = shouldTurnOnHeadlights(systemClock);
        Month month = LocalDateTime.now(systemClock).getMonth();
        return switch (month) {
            case JUNE, JULY, AUGUST -> new Cabrio(headlightsOn);
            case DECEMBER, JANUARY, FEBRUARY -> new SUV(headlightsOn);
            default -> new Sedan(headlightsOn);
        };
    }

    private boolean shouldTurnOnHeadlights(Clock clock) {
        int hour = LocalDateTime.now(clock).getHour();
        return hour >= 20 || hour < 6;
    }
}
