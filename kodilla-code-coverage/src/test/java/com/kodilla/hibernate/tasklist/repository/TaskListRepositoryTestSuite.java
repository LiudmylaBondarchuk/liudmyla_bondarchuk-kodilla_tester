package com.kodilla.hibernate.tasklist.repository;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Tag("integration")
class TaskListRepositoryTestSuite {

    @Autowired
    private TaskListRepository taskListRepository;

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList("Test List", "Test list description");
        taskListRepository.save(taskList);

        //When
        List<TaskList> readTaskLists = taskListRepository.findByListName("Test List");

        //Then
        Assertions.assertEquals(1, readTaskLists.size());
        Assertions.assertEquals("Test list description",
                readTaskLists.get(0).getDescription());

        //CleanUp
        int id = readTaskLists.get(0).getId();
        taskListRepository.deleteById(id);
    }
}
