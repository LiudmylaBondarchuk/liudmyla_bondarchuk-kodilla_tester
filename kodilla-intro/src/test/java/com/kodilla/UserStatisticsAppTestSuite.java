package com.kodilla;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserStatisticsApp Test Suite")
class UserStatisticsAppTestSuite {

    @DisplayName("should return correct name from getter")
    @Test
    void testGetName() {
        // given
        UserStatisticsApp user = new UserStatisticsApp("Alice", 25, 170.5);

        // when & then
        assertEquals("Alice", user.getName());
    }

    @DisplayName("should return correct age from getter")
    @Test
    void testGetAge() {
        // given
        UserStatisticsApp user = new UserStatisticsApp("Alice", 25, 170.5);

        // when & then
        assertEquals(25, user.getAge());
    }

    @DisplayName("should return correct height from getter")
    @Test
    void testGetHeight() {
        // given
        UserStatisticsApp user = new UserStatisticsApp("Alice", 25, 170.5);

        // when & then
        assertEquals(170.5, user.getHeight(), 0.001);
    }

    @DisplayName("should store all constructor values correctly")
    @Test
    void testConstructorStoresAllValues() {
        // given
        String name = "Bob";
        int age = 40;
        double height = 180.0;

        // when
        UserStatisticsApp user = new UserStatisticsApp(name, age, height);

        // then
        assertAll(
                () -> assertEquals(name, user.getName()),
                () -> assertEquals(age, user.getAge()),
                () -> assertEquals(height, user.getHeight(), 0.001)
        );
    }
}
