package com.kodilla.exception.warehouse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Warehouse Tests")
class WarehouseAppTestSuite {

    @Test
    @DisplayName("should find order by number")
    void shouldFindOrderByNumber() throws OrderDoesntExistException {
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
    @DisplayName("should throw exception when order does not exist")
    void shouldThrowExceptionWhenOrderDoesNotExist() {
        // given
        Warehouse warehouse = new Warehouse();
        warehouse.addOrder(new Order("123"));

        // when & then
        assertThrows(OrderDoesntExistException.class, () -> warehouse.getOrder("999"));
    }
}
