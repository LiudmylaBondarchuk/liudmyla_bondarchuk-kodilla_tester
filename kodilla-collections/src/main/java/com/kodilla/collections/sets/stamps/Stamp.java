package com.kodilla.collections.sets.stamps;

import java.util.Objects;

public class Stamp {
    private final String name;
    private final double width;
    private final double height;
    private final boolean stamped;

    public Stamp(String name, double width, double height, boolean stamped) {
        Objects.requireNonNull(name, "name must not be null");
        if (width <= 0) {
            throw new IllegalArgumentException("width must be positive");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("height must be positive");
        }
        this.name = name;
        this.width = width;
        this.height = height;
        this.stamped = stamped;
    }

    public String getName(){
        return name;
    }
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public boolean isStamped() {
        return stamped;
    }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stamp stamp = (Stamp) o;
        return Double.compare(stamp.width, width) == 0 &&
               Double.compare(stamp.height, height) == 0 &&
               stamped == stamp.stamped &&
                Objects.equals(name, stamp.name);
    }

    @Override public int hashCode() {
        return Objects.hash(name, width, height, stamped);
    }

    @Override
    public String toString() {
        return "Stamp{" +
                "name='" + name + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", stamped=" + stamped +
                '}';
    }
}
