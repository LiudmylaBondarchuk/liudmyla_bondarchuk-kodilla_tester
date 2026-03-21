package com.kodilla.abstracts.jobs;

import java.math.BigDecimal;

public class Tester extends Job {
    public Tester() {
        super(new BigDecimal("8"), "Writing and executing test cases, " +
                "reporting bugs, working with developers to resolve issues");
    }
}
