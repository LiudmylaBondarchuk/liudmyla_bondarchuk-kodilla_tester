package com.kodilla.com.stream;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

class UsersManagerTest {

    @Test
    void shouldReturnUsernamesFromChemistGroup() {
        // when
        List<String> chemists = UsersManager.filterChemistGroupUsernames();

        // then
        assertEquals(2, chemists.size());
        assertTrue(chemists.contains("Walter White"));
        assertTrue(chemists.contains("Gale Boetticher"));
    }

    @Test
    void shouldReturnUsersOlderThanGivenAge() {
        // given
        int ageThreshold = 45;

        // when
        List<User> olderUsers = UsersManager.filterUsersOlderThan(ageThreshold);

        // then
        assertFalse(olderUsers.isEmpty());
        assertTrue(olderUsers.stream().allMatch(user -> user.getAge() > ageThreshold));
        assertEquals(3, olderUsers.size());
        assertTrue(olderUsers.stream().anyMatch(user -> user.getUsername().equals("Walter White")));
        assertTrue(olderUsers.stream().anyMatch(user -> user.getUsername().equals("Mike Ehrmantraut")));
        assertTrue(olderUsers.stream().anyMatch(user -> user.getUsername().equals("Gus Firing")));
    }
    @Test
    void shouldReturnUsersWithMoreThanGivenNumberOfPosts() {
        // given
        int numberOfPosts = 100;

        // when
        List<User> usersWithMorePosts = UsersManager.filterUsersWithMoreThan(numberOfPosts);

        // then
        assertFalse(usersWithMorePosts.isEmpty());
        assertTrue(usersWithMorePosts.stream().allMatch(user -> user.getNumberOfPost() > numberOfPosts));
        assertEquals(2, usersWithMorePosts.size());
        assertTrue(usersWithMorePosts.stream().anyMatch(user -> user.getUsername().equals("Jessie Pinkman")));
        assertTrue(usersWithMorePosts.stream().anyMatch(user -> user.getUsername().equals("Tuco Salamanca")));
    }
}