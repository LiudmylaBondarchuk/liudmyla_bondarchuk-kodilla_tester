package com.kodilla.collections.sets;

import java.util.Objects;

public class Order {
    private final String orderNumber;
    private final String productName;
    private final int quantity;

    public Order(String orderNumber, String productName, int quantity) {
        Objects.requireNonNull(orderNumber, "orderNumber must not be null");
        Objects.requireNonNull(productName, "productName must not be null");
        if (orderNumber.isBlank()) {
            throw new IllegalArgumentException("orderNumber must not be blank");
        }
        if (productName.isBlank()) {
            throw new IllegalArgumentException("productName must not be blank");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be greater than 0");
        }
        this.orderNumber = orderNumber;
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Order order = (Order) o;
        return quantity == order.quantity
                && orderNumber.equals(order.orderNumber)
                && productName.equals(order.productName);
    }

    @Override public int hashCode() {
        return Objects.hash(orderNumber, productName, quantity);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
