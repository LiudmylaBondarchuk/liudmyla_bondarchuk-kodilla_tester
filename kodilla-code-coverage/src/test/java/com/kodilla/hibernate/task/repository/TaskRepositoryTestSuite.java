package com.kodilla.hibernate.task.repository;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
@Tag("integration")
class TaskRepositoryTestSuite {

    @Autowired
    private TaskRepository taskRepository;

    private static final String DESCRIPTION = "Test: Learn Hibernate";

    @Test
    void testTaskRepositoryFindByDuration() {
        //Given
        Task task = new Task(DESCRIPTION, 7);
        taskRepository.save(task);
        int duration = task.getDuration();

        //When
        List<Task> readTasks = taskRepository.findByDuration(duration);

        //Then
        Assertions.assertEquals(1, readTasks.size());

        //CleanUp
        int id = readTasks.get(0).getId();
        taskRepository.deleteById(id);
    }

    @Test
    void testTaskRepositorySaveWithFinancialDetails() {
        //Given
        Task task = new Task(DESCRIPTION, 14);
        task.setTaskFinancialDetails(new TaskFinancialDetails(new BigDecimal("1500.00"), false));
        taskRepository.save(task);

        //When
        List<Task> readTasks = taskRepository.findByDuration(14);

        //Then
        Assertions.assertEquals(1, readTasks.size());
        Assertions.assertNotNull(readTasks.get(0).getTaskFinancialDetails());
        Assertions.assertEquals(
                new BigDecimal("1500.00"),
                readTasks.get(0).getTaskFinancialDetails().getPrice());

        //CleanUp
        int id = readTasks.get(0).getId();
        taskRepository.deleteById(id);
    }
}
