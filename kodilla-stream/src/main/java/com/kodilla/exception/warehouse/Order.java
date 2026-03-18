package com.kodilla.exception.warehouse;

import java.util.Objects;

public class Order {
    private final String number;

    public Order(String number) {
        Objects.requireNonNull(number, "number must not be null");
        if (number.isEmpty()) {
            throw new IllegalArgumentException("number must not be empty");
        }
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(number, order.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Order{" +
                "number='" + number + '\'' +
                '}';
    }
}
