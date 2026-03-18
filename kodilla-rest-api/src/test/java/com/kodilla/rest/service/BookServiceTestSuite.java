package com.kodilla.rest.service;

import com.kodilla.rest.domain.BookDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("BookService Tests")
class BookServiceTestSuite {

    @Test
    @DisplayName("should return initial books")
    void shouldReturnInitialBooks() {
        BookService service = new BookService();
        List<BookDto> books = service.getBooks();
        assertThat(books).hasSize(3);
    }

    @Test
    @DisplayName("should add book and assign id")
    void shouldAddBookAndAssignId() {
        BookService service = new BookService();
        BookDto newBook = new BookDto("Test", "Author");
        BookDto saved = service.addBook(newBook);
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getTitle()).isEqualTo("Test");
        assertThat(service.getBooks()).hasSize(4);
    }

    @Test
    @DisplayName("should not mutate incoming DTO")
    void shouldNotMutateIncomingDto() {
        BookService service = new BookService();
        BookDto input = new BookDto("Test", "Author");
        BookDto saved = service.addBook(input);
        assertThat(input.getId()).isNull();
        assertThat(saved.getId()).isNotNull();
    }

    @Test
    @DisplayName("should find book by id")
    void shouldFindBookById() {
        BookService service = new BookService();
        Optional<BookDto> found = service.findById(1L);
        assertThat(found).isPresent();
        assertThat(found.get().getTitle()).isEqualTo("Hobbit");
    }

    @Test
    @DisplayName("should return empty when book not found")
    void shouldReturnEmptyWhenBookNotFound() {
        BookService service = new BookService();
        Optional<BookDto> found = service.findById(999L);
        assertThat(found).isEmpty();
    }

    @Test
    @DisplayName("should remove book by id")
    void shouldRemoveBookById() {
        BookService service = new BookService();
        boolean removed = service.removeById(1L);
        assertThat(removed).isTrue();
        assertThat(service.getBooks()).hasSize(2);
    }

    @Test
    @DisplayName("should return false when removing nonexistent book")
    void shouldReturnFalseWhenRemovingNonexistent() {
        BookService service = new BookService();
        boolean removed = service.removeById(999L);
        assertThat(removed).isFalse();
    }

    @Test
    @DisplayName("should return defensive copy of books list")
    void shouldReturnDefensiveCopy() {
        BookService service = new BookService();
        List<BookDto> books = service.getBooks();
        books.clear();
        assertThat(service.getBooks()).hasSize(3);
    }
}
