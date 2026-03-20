package com.kodilla.hibernate.task;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "TASKS_FINANCIALS")
@Access(AccessType.FIELD)
public class TaskFinancialDetails {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private int id;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "PAID")
    private boolean paid;

    // JPA requires no-arg constructor — validation is in the parameterized constructor
    public TaskFinancialDetails() {
    }

    public TaskFinancialDetails(BigDecimal price, boolean paid) {
        Objects.requireNonNull(price, "price must not be null");
        if (price.signum() < 0) {
            throw new IllegalArgumentException("price must not be negative");
        }
        this.price = price;
        this.paid = paid;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isPaid() {
        return paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskFinancialDetails that = (TaskFinancialDetails) o;
        return paid == that.paid && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, paid);
    }
}
