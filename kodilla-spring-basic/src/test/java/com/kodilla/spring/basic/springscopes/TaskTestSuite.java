package com.kodilla.spring.basic.springscopes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Task Scope Tests")
class TaskTestSuite {
    @Test
    @DisplayName("should create different task instances (prototype scope)")
    void shouldCreateDifferentTasks() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        Task firstBean = context.getBean(Task.class);
        Task secondBean = context.getBean(Task.class);
        Task thirdBean = context.getBean(Task.class);
        assertNotEquals(firstBean, secondBean);
        assertNotEquals(secondBean, thirdBean);
        assertNotEquals(firstBean, thirdBean);
    }
}
