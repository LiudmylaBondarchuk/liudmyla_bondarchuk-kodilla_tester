package com.kodilla.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("AverageAge Tests")
class AverageAgeTestSuite {

    @Test
    @DisplayName("should calculate average age from repository")
    void shouldCalculateAverageAgeFromRepository() {
        // given
        List<User> users = UsersRepository.getUsersList();

        // when
        double avg = users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0.0);

        // then
        assertTrue(avg > 0);
        assertEquals(43.17, avg, 0.01);
    }

    @Test
    @DisplayName("should return 0 for empty list")
    void shouldReturnZeroForEmptyList() {
        double avg = List.<User>of().stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0.0);

        assertEquals(0.0, avg);
    }
}
