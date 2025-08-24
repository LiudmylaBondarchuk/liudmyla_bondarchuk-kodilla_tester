package com.kodilla.execution_model.homework;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Shop {

    private Set<Order> orders = new HashSet<>();

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public List<Order> getOrdersBetweenDates(LocalDate from, LocalDate to) {
        return orders.stream()
                .filter(order -> !order.getDate().isBefore(from) && !order.getDate().isAfter(to))
                .collect(Collectors.toList());
    }

    public List<Order> getOrdersByValueRange(double minValue, double maxValue) {
        return orders.stream()
                .filter(order -> order.getValue() >= minValue && order.getValue() <= maxValue)
                .collect(Collectors.toList());
    }

    public int getNumberOfOrders() {
        return orders.size();
    }

    public double getTotalValue() {
        return orders.stream()
                .mapToDouble(Order::getValue)
                .sum();
    }

    public void clear() {
        orders.clear();
    }
}
