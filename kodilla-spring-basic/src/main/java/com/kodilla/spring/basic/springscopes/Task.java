package com.kodilla.spring.basic.springscopes;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class Task {
    public Task() {
        System.out.println("Creating new task bean...");
    }
}
