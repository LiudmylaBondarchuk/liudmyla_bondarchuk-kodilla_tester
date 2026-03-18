package com.kodilla.exception.warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Warehouse {
    private final List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        Objects.requireNonNull(order, "Order must not be null");
        orders.add(order);
    }

    public Order getOrder(String number) throws OrderDoesntExistException {
        return orders.stream()
                .filter(order -> order.getNumber().equals(number))
                .findFirst()
                .orElseThrow(() -> new OrderDoesntExistException("Order with number " + number + " does not exist."));
    }
}
