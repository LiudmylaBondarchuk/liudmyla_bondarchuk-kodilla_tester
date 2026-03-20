package com.kodilla.execution.shop;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Shop {

    private final Set<Order> orders = new HashSet<>();

    public void addOrder(Order order) {
        java.util.Objects.requireNonNull(order, "Order must not be null");
        this.orders.add(order);
    }

    public List<Order> getOrdersBetweenDates(LocalDate from, LocalDate to) {
        return orders.stream()
                .filter(order -> !order.getDate().isBefore(from) && !order.getDate().isAfter(to))
                .collect(Collectors.toList());
    }

    public List<Order> getOrdersByValueRange(BigDecimal minValue, BigDecimal maxValue) {
        return orders.stream()
                .filter(order -> order.getValue().compareTo(minValue) >= 0 && order.getValue().compareTo(maxValue) <= 0)
                .collect(Collectors.toList());
    }

    public int getNumberOfOrders() {
        return orders.size();
    }

    public BigDecimal getTotalValue() {
        return orders.stream()
                .map(Order::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void clear() {
        orders.clear();
    }
}
