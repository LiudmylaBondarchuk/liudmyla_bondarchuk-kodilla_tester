package com.kodilla.collections.adv.immutable.tasks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Task record test suite")
class TaskTestSuite {

    @Test
    @DisplayName("should create task with valid title and duration")
    void testCreateTask() {
        //given & when
        Task task = new Task("Write report", 5);

        //then
        assertEquals("Write report", task.title());
        assertEquals(5, task.duration());
    }

    @Test
    @DisplayName("should be equal when title and duration match")
    void testEqualTasks() {
        //given
        Task task1 = new Task("Write report", 5);
        Task task2 = new Task("Write report", 5);

        //when & then
        assertEquals(task1, task2);
        assertEquals(task1.hashCode(), task2.hashCode());
    }

    @Test
    @DisplayName("should not be equal when title differs")
    void testNotEqualDifferentTitle() {
        //given
        Task task1 = new Task("Write report", 5);
        Task task2 = new Task("Read book", 5);

        //when & then
        assertNotEquals(task1, task2);
    }

    @Test
    @DisplayName("should not be equal when duration differs")
    void testNotEqualDifferentDuration() {
        //given
        Task task1 = new Task("Write report", 5);
        Task task2 = new Task("Write report", 10);

        //when & then
        assertNotEquals(task1, task2);
    }

    @Test
    @DisplayName("should return readable toString")
    void testToString() {
        //given
        Task task = new Task("Write report", 5);

        //when
        String result = task.toString();

        //then
        assertTrue(result.contains("Write report"));
        assertTrue(result.contains("5"));
    }
}
