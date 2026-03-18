package com.kodilla.spring.basic.springconfig.vehicle;
public class SUV implements Car {
    private final boolean headlightsOn;
    public SUV(boolean headlightsOn) { this.headlightsOn = headlightsOn; }
    @Override
    public boolean hasHeadlightsTurnedOn() { return headlightsOn; }
    @Override
    public String getCarType() { return "SUV"; }
}
