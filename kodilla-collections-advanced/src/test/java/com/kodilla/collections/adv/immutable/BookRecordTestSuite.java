package com.kodilla.collections.adv.immutable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BookRecord test suite")
class BookRecordTestSuite {

    @Test
    @DisplayName("should create record with valid fields")
    void testCreateBookRecord() {
        //given & when
        BookRecord record = new BookRecord("George Orwell", "1984", 1949);

        //then
        assertEquals("George Orwell", record.author());
        assertEquals("1984", record.title());
        assertEquals(1949, record.year());
    }

    @Test
    @DisplayName("should be equal when all fields match")
    void testEqualRecords() {
        //given
        BookRecord record1 = new BookRecord("George Orwell", "1984", 1949);
        BookRecord record2 = new BookRecord("George Orwell", "1984", 1949);

        //when & then
        assertEquals(record1, record2);
        assertEquals(record1.hashCode(), record2.hashCode());
    }

    @Test
    @DisplayName("should not be equal when year differs")
    void testNotEqualDifferentYear() {
        //given
        BookRecord record1 = new BookRecord("George Orwell", "1984", 1949);
        BookRecord record2 = new BookRecord("George Orwell", "1984", 2000);

        //when & then
        assertNotEquals(record1, record2);
    }

    @Test
    @DisplayName("should return readable toString")
    void testToString() {
        //given
        BookRecord record = new BookRecord("George Orwell", "1984", 1949);

        //when
        String result = record.toString();

        //then
        assertTrue(result.contains("George Orwell"));
        assertTrue(result.contains("1984"));
        assertTrue(result.contains("1949"));
    }
}
