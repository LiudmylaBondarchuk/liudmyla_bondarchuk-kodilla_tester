package com.kodilla.spring.basic.injection.shipping;

import java.util.Objects;

public class DeliveryService implements DeliveryServiceInterface {

    private static final double MAX_WEIGHT = 30.0;

    @Override
    public boolean deliverPackage(String address, double weight) {
        Objects.requireNonNull(address, "address must not be null");
        if (weight <= 0) {
            throw new IllegalArgumentException("weight must be positive");
        }
        return weight <= MAX_WEIGHT;
    }
}
