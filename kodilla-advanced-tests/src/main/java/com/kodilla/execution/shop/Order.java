package com.kodilla.execution.shop;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Order {
    private final BigDecimal value;
    private final LocalDate date;
    private final String login;

    public Order(BigDecimal value, LocalDate date, String login) {
        Objects.requireNonNull(value, "value must not be null");
        Objects.requireNonNull(date, "date must not be null");
        Objects.requireNonNull(login, "login must not be null");
        this.value = value;
        this.date = date;
        this.login = login;
    }

    public BigDecimal getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return "Order{value=" + value + ", date=" + date + ", login='" + login + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(value, order.value) &&
                Objects.equals(date, order.date) &&
                Objects.equals(login, order.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, date, login);
    }
}
