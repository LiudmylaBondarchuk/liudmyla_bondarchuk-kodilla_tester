package com.kodilla.spring.basic.springscopes.clock;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.time.LocalTime;
@Component
@Scope("prototype")
public class Clock {
    private final LocalTime time;
    public Clock() {
        this.time = LocalTime.now();
    }
    public LocalTime getTime() { return time; }
}
