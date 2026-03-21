package com.kodilla.abstracts.jobs;

import java.math.BigDecimal;

public class BusinessAnalyst extends Job {
    public BusinessAnalyst() {
        super(new BigDecimal("11"), "Gathering requirements, " +
                "writing specifications, working with both business " +
                "and development teams");
    }
}
