package com.kodilla.spring.basic.springconfig.vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDateTime;
import java.time.Month;
@Configuration
public class CarFactory {
    @Bean
    public Car seasonCar() {
        boolean headlightsOn = shouldTurnOnHeadlights();
        Month month = LocalDateTime.now().getMonth();
        return switch (month) {
            case JUNE, JULY, AUGUST -> new Cabrio(headlightsOn);
            case DECEMBER, JANUARY, FEBRUARY -> new SUV(headlightsOn);
            default -> new Sedan(headlightsOn);
        };
    }
    private boolean shouldTurnOnHeadlights() {
        int hour = LocalDateTime.now().getHour();
        return hour >= 20 || hour < 6;
    }
}
