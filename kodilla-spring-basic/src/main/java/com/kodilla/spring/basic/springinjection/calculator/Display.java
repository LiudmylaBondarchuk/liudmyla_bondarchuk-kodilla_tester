package com.kodilla.spring.basic.springinjection.calculator;
import org.springframework.stereotype.Component;
@Component
public class Display {
    public void display(double value) {
        System.out.println(value);
    }
}
