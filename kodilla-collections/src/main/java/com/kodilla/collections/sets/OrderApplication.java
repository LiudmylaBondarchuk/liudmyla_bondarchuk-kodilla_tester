package com.kodilla.collections.sets.sets;
import java.util.HashSet;
import java.util.Set;

public class OrderApplication {
    public static void main(String[] args) {
        Set<Order> orders = new HashSet<>();
        orders.add(new Order("1/2019", "Iron", 1.0));
        orders.add(new Order("2/2019", "Cutlery", 6.0));
        orders.add(new Order("3/2019", "Chair", 2.0));
        orders.add(new Order("1/2019", "Iron", 1.0));

        System.out.println(orders.size());
        for (Order order : orders)
            System.out.println(order);
    }
}