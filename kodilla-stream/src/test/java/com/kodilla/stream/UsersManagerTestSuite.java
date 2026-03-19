package com.kodilla.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UsersManager test suite")
class UsersManagerTestSuite {

    @Test
    @DisplayName("should return usernames from Chemists group")
    void shouldReturnUsernamesFromChemistGroup() {
        // when
        List<String> chemists = UsersManager.filterChemistGroupUsernames();

        // then
        assertEquals(2, chemists.size());
        assertTrue(chemists.contains("Walter White"));
        assertTrue(chemists.contains("Gale Boetticher"));
    }

    @Test
    @DisplayName("should return users older than given age")
    void shouldReturnUsersOlderThanGivenAge() {
        // given
        int ageThreshold = 45;

        // when
        List<User> olderUsers = UsersManager.filterUsersOlderThan(ageThreshold);

        // then
        assertFalse(olderUsers.isEmpty());
        assertTrue(olderUsers.stream()
                .allMatch(user -> user.getAge() > ageThreshold));
        assertEquals(3, olderUsers.size());
    }

    @Test
    @DisplayName("should return users with more than given number of posts")
    void shouldReturnUsersWithMoreThanGivenNumberOfPosts() {
        // given
        int numberOfPosts = 100;

        // when
        List<User> usersWithMorePosts =
                UsersManager.filterUsersWithMoreThan(numberOfPosts);

        // then
        assertFalse(usersWithMorePosts.isEmpty());
        assertTrue(usersWithMorePosts.stream()
                .allMatch(user -> user.getNumberOfPost() > numberOfPosts));
        assertEquals(2, usersWithMorePosts.size());
    }
}
