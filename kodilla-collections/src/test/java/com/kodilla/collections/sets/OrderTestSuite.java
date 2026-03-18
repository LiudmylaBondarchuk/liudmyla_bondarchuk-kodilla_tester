package com.kodilla.collections.sets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Order equals, hashCode and Set behavior test suite")
class OrderTestSuite {

    @Test
    @DisplayName("should be equal when all fields match")
    void shouldBeEqualWhenAllFieldsMatch() {
        Order order1 = new Order("ORD-001", "Laptop", 1.0);
        Order order2 = new Order("ORD-001", "Laptop", 1.0);
        assertEquals(order1, order2);
    }

    @Test
    @DisplayName("should not be equal when order number differs")
    void shouldNotBeEqualWhenOrderNumberDiffers() {
        Order order1 = new Order("ORD-001", "Laptop", 1.0);
        Order order2 = new Order("ORD-002", "Laptop", 1.0);
        assertNotEquals(order1, order2);
    }

    @Test
    @DisplayName("should not be equal when product name differs")
    void shouldNotBeEqualWhenProductNameDiffers() {
        Order order1 = new Order("ORD-001", "Laptop", 1.0);
        Order order2 = new Order("ORD-001", "Phone", 1.0);
        assertNotEquals(order1, order2);
    }

    @Test
    @DisplayName("should not be equal when quantity differs")
    void shouldNotBeEqualWhenQuantityDiffers() {
        Order order1 = new Order("ORD-001", "Laptop", 1.0);
        Order order2 = new Order("ORD-001", "Laptop", 2.0);
        assertNotEquals(order1, order2);
    }

    @Test
    @DisplayName("should have same hashCode for equal objects")
    void shouldHaveSameHashCodeForEqualObjects() {
        Order order1 = new Order("ORD-001", "Laptop", 1.0);
        Order order2 = new Order("ORD-001", "Laptop", 1.0);
        assertEquals(order1.hashCode(), order2.hashCode());
    }

    @Test
    @DisplayName("should return meaningful toString")
    void shouldReturnMeaningfulToString() {
        Order order = new Order("ORD-001", "Laptop", 1.0);
        String result = order.toString();
        assertTrue(result.contains("ORD-001"));
        assertTrue(result.contains("Laptop"));
        assertTrue(result.contains("1.0"));
    }

    @Test
    @DisplayName("should remove duplicates when adding to Set")
    void shouldRemoveDuplicatesInSet() {
        // given
        Set<Order> orders = new HashSet<>();
        Order order1 = new Order("ORD-001", "Laptop", 1.0);
        Order order2 = new Order("ORD-001", "Laptop", 1.0);
        Order order3 = new Order("ORD-002", "Phone", 3.0);
        // when
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        // then
        assertEquals(2, orders.size());
    }

    @Test
    @DisplayName("should keep all unique orders in Set")
    void shouldKeepAllUniqueOrdersInSet() {
        // given
        Set<Order> orders = new HashSet<>();
        orders.add(new Order("ORD-001", "Laptop", 1.0));
        orders.add(new Order("ORD-002", "Phone", 2.0));
        orders.add(new Order("ORD-003", "Tablet", 1.0));
        // then
        assertEquals(3, orders.size());
    }

    @Test
    @DisplayName("should not be equal to null")
    void shouldNotBeEqualToNull() {
        Order order = new Order("ORD-001", "Laptop", 1.0);
        assertNotEquals(null, order);
    }

    @Test
    @DisplayName("should be equal to itself (reflexive)")
    void shouldBeEqualToItself() {
        Order order = new Order("ORD-001", "Laptop", 1.0);
        assertEquals(order, order);
    }
}
