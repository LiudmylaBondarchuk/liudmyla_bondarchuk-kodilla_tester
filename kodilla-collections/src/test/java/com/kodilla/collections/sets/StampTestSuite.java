package com.kodilla.collections.sets;

import com.kodilla.collections.sets.stamps.Stamp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Stamp equals, hashCode and Set behavior test suite")
class StampTestSuite {

    @Test
    @DisplayName("should be equal when all fields match")
    void shouldBeEqualWhenAllFieldsMatch() {
        Stamp stamp1 = new Stamp("Rose", 3.0, 4.0, true);
        Stamp stamp2 = new Stamp("Rose", 3.0, 4.0, true);
        assertEquals(stamp1, stamp2);
    }

    @Test
    @DisplayName("should not be equal when name differs")
    void shouldNotBeEqualWhenNameDiffers() {
        Stamp stamp1 = new Stamp("Rose", 3.0, 4.0, true);
        Stamp stamp2 = new Stamp("Tulip", 3.0, 4.0, true);
        assertNotEquals(stamp1, stamp2);
    }

    @Test
    @DisplayName("should not be equal when width differs")
    void shouldNotBeEqualWhenWidthDiffers() {
        Stamp stamp1 = new Stamp("Rose", 3.0, 4.0, true);
        Stamp stamp2 = new Stamp("Rose", 5.0, 4.0, true);
        assertNotEquals(stamp1, stamp2);
    }

    @Test
    @DisplayName("should not be equal when height differs")
    void shouldNotBeEqualWhenHeightDiffers() {
        Stamp stamp1 = new Stamp("Rose", 3.0, 4.0, true);
        Stamp stamp2 = new Stamp("Rose", 3.0, 6.0, true);
        assertNotEquals(stamp1, stamp2);
    }

    @Test
    @DisplayName("should not be equal when stamped flag differs")
    void shouldNotBeEqualWhenStampedDiffers() {
        Stamp stamp1 = new Stamp("Rose", 3.0, 4.0, true);
        Stamp stamp2 = new Stamp("Rose", 3.0, 4.0, false);
        assertNotEquals(stamp1, stamp2);
    }

    @Test
    @DisplayName("should have same hashCode for equal objects")
    void shouldHaveSameHashCodeForEqualObjects() {
        Stamp stamp1 = new Stamp("Rose", 3.0, 4.0, true);
        Stamp stamp2 = new Stamp("Rose", 3.0, 4.0, true);
        assertEquals(stamp1.hashCode(), stamp2.hashCode());
    }

    @Test
    @DisplayName("should return meaningful toString")
    void shouldReturnMeaningfulToString() {
        Stamp stamp = new Stamp("Rose", 3.0, 4.0, true);
        String result = stamp.toString();
        assertTrue(result.contains("Rose"));
        assertTrue(result.contains("3.0"));
        assertTrue(result.contains("4.0"));
        assertTrue(result.contains("true"));
    }

    @Test
    @DisplayName("should remove duplicates when adding to Set")
    void shouldRemoveDuplicatesInSet() {
        // given
        Set<Stamp> stamps = new HashSet<>();
        Stamp stamp1 = new Stamp("Rose", 3.0, 4.0, true);
        Stamp stamp2 = new Stamp("Rose", 3.0, 4.0, true);
        Stamp stamp3 = new Stamp("Tulip", 2.0, 3.0, false);
        // when
        stamps.add(stamp1);
        stamps.add(stamp2);
        stamps.add(stamp3);
        // then
        assertEquals(2, stamps.size());
    }

    @Test
    @DisplayName("should keep all unique stamps in Set")
    void shouldKeepAllUniqueStampsInSet() {
        // given
        Set<Stamp> stamps = new HashSet<>();
        stamps.add(new Stamp("Rose", 3.0, 4.0, true));
        stamps.add(new Stamp("Tulip", 2.0, 3.0, false));
        stamps.add(new Stamp("Lily", 4.0, 5.0, true));
        // then
        assertEquals(3, stamps.size());
    }

    @Test
    @DisplayName("should be equal to itself (reflexive)")
    void shouldBeEqualToItself() {
        Stamp stamp = new Stamp("Rose", 3.0, 4.0, true);
        assertEquals(stamp, stamp);
    }

    @Test
    @DisplayName("should not be equal to null")
    void shouldNotBeEqualToNull() {
        Stamp stamp = new Stamp("Rose", 3.0, 4.0, true);
        assertNotEquals(null, stamp);
    }
}
