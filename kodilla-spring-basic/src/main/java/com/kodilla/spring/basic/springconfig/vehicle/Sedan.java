package com.kodilla.spring.basic.springconfig.vehicle;
public class Sedan implements Car {
    private final boolean headlightsOn;
    public Sedan(boolean headlightsOn) { this.headlightsOn = headlightsOn; }
    @Override
    public boolean hasHeadlightsTurnedOn() { return headlightsOn; }
    @Override
    public String getCarType() { return "Sedan"; }
}
