package com.kodilla.com.exception.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WarehouseAppTestSuite {

    @Test
    public void testGetOrder_found() throws OrderDoesntExistException {
        // given
        Warehouse warehouse = new Warehouse();
        warehouse.addOrder(new Order("123"));
        warehouse.addOrder(new Order("456"));

        // when
        Order foundOrder = warehouse.getOrder("456");

        // then
        assertNotNull(foundOrder);
        assertEquals("456", foundOrder.getNumber());
    }

    @Test
    public void testGetOrder_notFound_throwsException() {
        // given
        Warehouse warehouse = new Warehouse();
        warehouse.addOrder(new Order("123"));

        // when
        //  then
        assertThrows(OrderDoesntExistException.class, () -> warehouse.getOrder("999"));
    }
}