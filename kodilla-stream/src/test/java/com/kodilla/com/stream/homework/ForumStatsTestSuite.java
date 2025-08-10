package com.kodilla.com.stream.homework;

import com.kodilla.com.stream.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ForumStatsTestSuite {

    @Test
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
    void shouldReturnZeroForEmptyUserList() {
        // given
        List<User> users = List.of();
        // when
        double resultAtLeast40 = ForumStats.averagePostsForUsersOlderThanOrEqual40(users);
        double resultYounger40 = ForumStats.averagePostsForUsersYoungerThan40(users);
        // then
        assertEquals(0.0, resultAtLeast40, 0.01);
        assertEquals(0.0, resultYounger40, 0.01);
    }
}
