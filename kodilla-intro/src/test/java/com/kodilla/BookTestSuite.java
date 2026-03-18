package com.kodilla;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Book Test Suite")
class BookTestSuite {

    @DisplayName("should create book via factory method")
    @Test
    void testFactoryMethod() {
        // when
        Book book = Book.of("Orwell", "1984");

        // then
        assertNotNull(book);
    }

    @DisplayName("should return correct author from getter")
    @Test
    void testGetAuthor() {
        // given
        Book book = Book.of("Orwell", "1984");

        // when & then
        assertEquals("Orwell", book.getAuthor());
    }

    @DisplayName("should return correct title from getter")
    @Test
    void testGetTitle() {
        // given
        Book book = Book.of("Orwell", "1984");

        // when & then
        assertEquals("1984", book.getTitle());
    }

    @DisplayName("should be equal when author and title match")
    @Test
    void testEqualBooks() {
        // given
        Book book1 = Book.of("Orwell", "1984");
        Book book2 = Book.of("Orwell", "1984");

        // when & then
        assertEquals(book1, book2);
    }

    @DisplayName("should not be equal when author differs")
    @Test
    void testNotEqualDifferentAuthor() {
        // given
        Book book1 = Book.of("Orwell", "1984");
        Book book2 = Book.of("Huxley", "1984");

        // when & then
        assertNotEquals(book1, book2);
    }

    @DisplayName("should not be equal when title differs")
    @Test
    void testNotEqualDifferentTitle() {
        // given
        Book book1 = Book.of("Orwell", "1984");
        Book book2 = Book.of("Orwell", "Animal Farm");

        // when & then
        assertNotEquals(book1, book2);
    }

    @DisplayName("should have consistent hashCode for equal books")
    @Test
    void testHashCodeConsistency() {
        // given
        Book book1 = Book.of("Orwell", "1984");
        Book book2 = Book.of("Orwell", "1984");

        // when & then
        assertEquals(book1.hashCode(), book2.hashCode());
    }

    @DisplayName("should return formatted string from toString")
    @Test
    void testToString() {
        // given
        Book book = Book.of("Orwell", "1984");

        // when
        String result = book.toString();

        // then
        assertEquals("Book{author='Orwell', title='1984'}", result);
    }
}
