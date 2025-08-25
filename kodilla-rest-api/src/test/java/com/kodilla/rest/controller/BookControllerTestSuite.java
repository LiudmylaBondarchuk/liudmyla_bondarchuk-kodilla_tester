package com.kodilla.rest.controller;

import com.kodilla.rest.domain.BookDto;
import com.kodilla.rest.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BookControllerTestSuite {

    @Test
    void shouldFetchBooks() {
        // given
        BookService bookServiceMock = Mockito.mock(BookService.class);
        BookController bookController = new BookController(bookServiceMock);

        List<BookDto> booksList = new ArrayList<>();
        booksList.add(new BookDto(1L, "Title 1", "Author 1"));
        booksList.add(new BookDto(2L, "Title 2", "Author 2"));

        Mockito.when(bookServiceMock.getBooks()).thenReturn(booksList);

        // when
        ResponseEntity<List<BookDto>> response = bookController.getAllBooks();
        List<BookDto> result = response.getBody();

        // then
        assertThat(result).hasSize(2);
    }

    @Test
    void shouldAddBook() {
        // given
        BookService bookServiceMock = Mockito.mock(BookService.class);
        BookController bookController = new BookController(bookServiceMock);

        BookDto newBook = new BookDto(null, "Clean Code", "Robert Martin");
        BookDto savedBook = new BookDto(1L, "Clean Code", "Robert Martin");

        Mockito.when(bookServiceMock.addBook(newBook)).thenReturn(savedBook);

        // when
        ResponseEntity<BookDto> response = bookController.addBook(newBook);
        BookDto result = response.getBody();

        // then
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getTitle()).isEqualTo("Clean Code");
        assertThat(result.getAuthor()).isEqualTo("Robert Martin");

        Mockito.verify(bookServiceMock, Mockito.times(1)).addBook(newBook);
    }
}