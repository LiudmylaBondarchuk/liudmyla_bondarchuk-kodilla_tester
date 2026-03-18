package com.kodilla.spring.basic.springinjection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("SimpleApplication Spring DI Tests")
class SimpleApplicationTestSuite {
    @Test
    @DisplayName("should return correct message using Skype service")
    void shouldReturnCorrectMessage() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        SkypeMessageService bean = context.getBean(SkypeMessageService.class);
        String message = bean.send("Test", "Any receiver");
        assertNotNull(message);
    }
    @Test
    @DisplayName("should process message through SimpleApplication")
    void shouldProcessMessage() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        SimpleApplication bean = context.getBean(SimpleApplication.class);
        String message = bean.processMessage("Test", "Any receiver");
        assertEquals("Sending [Test] to: Any receiver using Skype", message);
    }
}
