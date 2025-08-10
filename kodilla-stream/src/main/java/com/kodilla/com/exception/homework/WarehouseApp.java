package com.kodilla.com.exception.homework;

public class WarehouseApp {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        warehouse.addOrder(new Order("123"));
        warehouse.addOrder(new Order("456"));
        warehouse.addOrder(new Order("789"));

        try {
            System.out.println("Found order: " + warehouse.getOrder("456").getNumber());
            System.out.println("Found order: " + warehouse.getOrder("000").getNumber());
        } catch (OrderDoesntExistException e) {
            System.out.println(e.toString());
        }
    }
}