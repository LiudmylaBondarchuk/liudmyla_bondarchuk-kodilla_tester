package com.kodilla.sets;

import java.util.Objects;

public class Order {
    private String orderNumber;
    private String productName;
    private double quantity;

    public Order(String orderNumber, String productName, double quantity) {
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

    public double getQuantity() {
        return quantity;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Order order = (Order) o;
        return Double.compare(quantity, order.quantity) == 0
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
