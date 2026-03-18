package com.kodilla.spring.basic.springconfig.vehicle;
public class Cabrio implements Car {
    private final boolean headlightsOn;
    public Cabrio(boolean headlightsOn) { this.headlightsOn = headlightsOn; }
    @Override
    public boolean hasHeadlightsTurnedOn() { return headlightsOn; }
    @Override
    public String getCarType() { return "Cabrio"; }
}
