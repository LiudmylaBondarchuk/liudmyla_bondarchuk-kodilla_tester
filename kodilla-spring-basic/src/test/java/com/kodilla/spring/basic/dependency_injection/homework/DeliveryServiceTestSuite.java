package com.kodilla.spring.basic.dependency_injection.homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DeliveryService Tests")
class DeliveryServiceTestSuite {

    private final DeliveryService deliveryService = new DeliveryService();

    @Test
    @DisplayName("should deliver package within weight limit")
    void shouldDeliverWithinWeightLimit() {
        assertTrue(deliveryService.deliverPackage("123 Main St", 25.0));
    }

    @Test
    @DisplayName("should reject package exceeding weight limit")
    void shouldRejectExceedingWeightLimit() {
        assertFalse(deliveryService.deliverPackage("123 Main St", 35.0));
    }

    @Test
    @DisplayName("should deliver package at exact weight limit")
    void shouldDeliverAtExactWeightLimit() {
        assertTrue(deliveryService.deliverPackage("123 Main St", 30.0));
    }
}
