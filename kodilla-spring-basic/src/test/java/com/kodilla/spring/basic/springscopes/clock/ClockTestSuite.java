package com.kodilla.spring.basic.springscopes.clock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Clock Scope Tests")
class ClockTestSuite {
    @Test
    @DisplayName("should create clock instances with different times")
    void shouldCreateClocksWithDifferentTimes() throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        Clock first = context.getBean(Clock.class);
        Thread.sleep(10);
        Clock second = context.getBean(Clock.class);
        assertNotEquals(first, second);
        assertNotNull(first.getTime());
        assertNotNull(second.getTime());
    }
}
