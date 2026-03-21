package com.kodilla.abstracts.jobs;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Job {
    private final BigDecimal salary;
    private final String responsibilities;

    public Job(BigDecimal salary, String responsibilities) {
        Objects.requireNonNull(salary, "salary must not be null");
        Objects.requireNonNull(responsibilities, "responsibilities must not be null");
        if (salary.signum() < 0) {
            throw new IllegalArgumentException("salary must not be negative");
        }
        this.salary = salary;
        this.responsibilities = responsibilities;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getResponsibilities() {
        return responsibilities;
    }
}
