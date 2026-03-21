package com.kodilla.abstracts.jobs;

import java.math.BigDecimal;

public class Developer extends Job {
    public Developer() {
        super(new BigDecimal("15"), "Writing and maintaining code, " +
                "implementing new features, fixing bugs");
    }
}
