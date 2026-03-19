package com.kodilla.spring.basic.springinjection.shipping;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DeliveryService {

    private static final double MAX_WEIGHT = 30.0;

    public boolean deliverPackage(String address, double weight) {
        Objects.requireNonNull(address, "address must not be null");
        if (weight <= 0) {
            throw new IllegalArgumentException("weight must be positive");
        }
        return weight <= MAX_WEIGHT;
    }
}
