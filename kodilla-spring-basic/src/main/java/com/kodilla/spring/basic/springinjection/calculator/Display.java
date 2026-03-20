package com.kodilla.spring.basic.springinjection.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Display {

    private static final Logger logger = LoggerFactory.getLogger(Display.class);

    public void display(double value) {
        logger.info("{}", value);
    }
}
