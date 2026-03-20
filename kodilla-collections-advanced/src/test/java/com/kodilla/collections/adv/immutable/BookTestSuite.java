package com.kodilla.collections.adv.immutable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Book test suite")
class BookTestSuite {

    @Test
    @DisplayName("should create book with valid author and title")
    void testCreateBook() {
        //given & when
        Book book = new Book("George Orwell", "1984");

        //then
        assertEquals("George Orwell", book.getAuthor());
        assertEquals("1984", book.getTitle());
    }

    @Test
    @DisplayName("should throw NullPointerException when author is null")
    void testNullAuthor() {
        //given & when & then
        assertThrows(NullPointerException.class, () -> new Book(null, "1984"));
    }

    @Test
    @DisplayName("should throw NullPointerException when title is null")
    void testNullTitle() {
        //given & when & then
        assertThrows(NullPointerException.class, () -> new Book("George Orwell", null));
    }

    @Test
    @DisplayName("should be equal when author and title match")
    void testEqualBooks() {
        //given
        Book book1 = new Book("George Orwell", "1984");
        Book book2 = new Book("George Orwell", "1984");

        //when & then
        assertEquals(book1, book2);
        assertEquals(book1.hashCode(), book2.hashCode());
    }

    @Test
    @DisplayName("should not be equal when author differs")
    void testNotEqualDifferentAuthor() {
        //given
        Book book1 = new Book("George Orwell", "1984");
        Book book2 = new Book("Aldous Huxley", "1984");

        //when & then
        assertNotEquals(book1, book2);
    }

    @Test
    @DisplayName("should not be equal when title differs")
    void testNotEqualDifferentTitle() {
        //given
        Book book1 = new Book("George Orwell", "1984");
        Book book2 = new Book("George Orwell", "Animal Farm");

        //when & then
        assertNotEquals(book1, book2);
    }

    @Test
    @DisplayName("should not be equal to null")
    void testNotEqualToNull() {
        //given
        Book book = new Book("George Orwell", "1984");

        //when & then
        assertNotEquals(null, book);
    }

    @Test
    @DisplayName("should return readable toString")
    void testToString() {
        //given
        Book book = new Book("George Orwell", "1984");

        //when
        String result = book.toString();

        //then
        assertTrue(result.contains("George Orwell"));
        assertTrue(result.contains("1984"));
    }
}
