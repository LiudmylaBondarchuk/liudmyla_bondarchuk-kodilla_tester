package com.kodilla.stream.forum;

import com.kodilla.stream.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ForumStats test suite")
class ForumStatsTestSuite {

    @Test
    @DisplayName("should calculate average posts for users >= 40")
    void shouldCalculateAveragePostsForUsersOlderThanOrEqual40() {
        // given
        List<User> users = Arrays.asList(
                new User("userAged50", 50, 10, "Chemists"),
                new User("userAged40", 40, 20, "Sales"),
                new User("userAged39", 39, 30, "Board")
        );
        // when
        double result = ForumStats.averagePostsForUsersOlderThanOrEqual40(users);
        // then
        assertEquals(15.0, result, 0.01);
    }

    @Test
    @DisplayName("should calculate average posts for users < 40")
    void shouldCalculateAveragePostsForUsersYoungerThan40() {
        // given
        List<User> users = Arrays.asList(
                new User("userAged50", 50, 10, "Chemists"),
                new User("userAged40", 40, 20, "Sales"),
                new User("userAged39", 39, 30, "Board"),
                new User("userAged25", 25, 40, "Sales")
        );
        // when
        double result = ForumStats.averagePostsForUsersYoungerThan40(users);
        // then
        assertEquals(35.0, result, 0.01);
    }

    @Test
    @DisplayName("should return 0 if no users >= 40")
    void shouldReturnZeroIfNoUsersOlderThanOrEqual40() {
        // given
        List<User> users = Arrays.asList(
                new User("userAged20", 20, 10, "Chemists"),
                new User("userAged30", 30, 20, "Sales")
        );
        // when
        double result = ForumStats.averagePostsForUsersOlderThanOrEqual40(users);
        // then
        assertEquals(0.0, result, 0.01);
    }

    @Test
    @DisplayName("should return 0 if no users < 40")
    void shouldReturnZeroIfNoUsersYoungerThan40() {
        // given
        List<User> users = Arrays.asList(
                new User("userAged50", 50, 10, "Chemists"),
                new User("userAged60", 60, 20, "Sales")
        );
        // when
        double result = ForumStats.averagePostsForUsersYoungerThan40(users);
        // then
        assertEquals(0.0, result, 0.01);
    }

    @Test
    @DisplayName("should return 0 for empty user list")
    void shouldReturnZeroForEmptyUserList() {
        // given
        List<User> users = List.of();
        // when
        double resultAtLeast40 =
                ForumStats.averagePostsForUsersOlderThanOrEqual40(users);
        double resultYounger40 =
                ForumStats.averagePostsForUsersYoungerThan40(users);
        // then
        assertEquals(0.0, resultAtLeast40, 0.01);
        assertEquals(0.0, resultYounger40, 0.01);
    }
}
