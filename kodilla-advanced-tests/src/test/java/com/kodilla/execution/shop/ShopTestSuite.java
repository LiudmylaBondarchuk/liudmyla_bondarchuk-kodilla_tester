package com.kodilla.execution.shop;

import org.junit.jupiter.api.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Shop Tests")
class ShopTestSuite {

    Shop shop = new Shop();

    Order order1 = new Order(new BigDecimal("250.0"), LocalDate.of(2023, 3, 1), "adam123");
    Order order2 = new Order(new BigDecimal("99.99"), LocalDate.of(2023, 5, 15), "ola456");
    Order order3 = new Order(new BigDecimal("450.50"), LocalDate.of(2023, 7, 20), "michal789");
    Order order4 = new Order(new BigDecimal("300.0"), LocalDate.of(2023, 5, 10), "ola456");

    @BeforeEach
    public void init() {
        shop.addOrder(order1);
        shop.addOrder(order2);
        shop.addOrder(order3);
        shop.addOrder(order4);
    }

    @AfterEach
    public void reset() {
        shop.clear();
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println(">>> Starting Shop tests...");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println(">>> Finished Shop tests.");
    }

    @Test
    public void shouldAddOrdersToShop() {
        //When
        int numberOfOrders = shop.getNumberOfOrders();

        //Then
        assertEquals(4, numberOfOrders);
    }

    @Test
    public void shouldNotAddDuplicateOrders() {
        //When
        shop.addOrder(order1);

        //Then
        assertEquals(4, shop.getNumberOfOrders()); // Set -> unikalność
    }

    @Test
    public void shouldReturnOrdersFromDateRange() {
        //When
        List<Order> result = shop.getOrdersBetweenDates(
                LocalDate.of(2023, 5, 1),
                LocalDate.of(2023, 6, 1));

        //Then
        assertEquals(2, result.size()); // order2 and order4
        assertTrue(result.contains(order2));
        assertTrue(result.contains(order4));
    }

    @Test
    public void shouldReturnOrdersFromValueRange() {
        //When
        List<Order> result = shop.getOrdersByValueRange(new BigDecimal("200.0"), new BigDecimal("400.0"));

        //Then
        assertEquals(2, result.size()); // order1 and order4
        assertTrue(result.contains(order1));
        assertTrue(result.contains(order4));
    }

    @Test
    public void shouldReturnEmptyListWhenNoOrdersInDateRange() {
        //When
        List<Order> result = shop.getOrdersBetweenDates(
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 12, 31));

        //Then
        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldReturnEmptyListWhenNoOrdersInValueRange() {
        //When
        List<Order> result = shop.getOrdersByValueRange(new BigDecimal("1000.0"), new BigDecimal("2000.0"));

        //Then
        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldSumAllOrdersValues() {
        //When
        BigDecimal sum = shop.getTotalValue();

        //Then
        assertEquals(new BigDecimal("1100.49"), sum);
    }
}