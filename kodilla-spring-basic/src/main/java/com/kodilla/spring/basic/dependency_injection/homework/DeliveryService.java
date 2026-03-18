package com.kodilla.spring.basic.dependency_injection.homework;

import org.springframework.stereotype.Service;

@Service
public class DeliveryService implements DeliveryServiceInterface {

    private static final double MAX_WEIGHT = 30.0;

    @Override
    public boolean deliverPackage(String address, double weight) {
        if (weight > MAX_WEIGHT) {
            System.out.println("Package too heavy");
            return false;
        }
        System.out.println("Delivering in progress...");
        return true;
    }
}
