package com.kodilla.rest.controller;

import com.kodilla.rest.domain.BookDto;
import com.kodilla.rest.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("BookController test suite")
class BookControllerTestSuite {

    private BookService bookServiceMock;
    private BookController controller;

    @BeforeEach
    void setUp() {
        bookServiceMock = Mockito.mock(BookService.class);
        controller = new BookController(bookServiceMock);
    }

    @DisplayName("Should fetch all books")
    @Test
    void shouldFetchBooks() {
        // given
        List<BookDto> booksList = new ArrayList<>();
        booksList.add(new BookDto(1L, "Title 1", "Author 1"));
        booksList.add(new BookDto(2L, "Title 2", "Author 2"));

        Mockito.when(bookServiceMock.getBooks()).thenReturn(booksList);

        // when
        ResponseEntity<List<BookDto>> response = controller.getAllBooks();

        // then
        assertThat(response.getBody()).isNotNull();
        List<BookDto> result = response.getBody();
        assertThat(result).hasSize(2);
    }

    @DisplayName("Should add a new book")
    @Test
    void shouldAddBook() {
        // given
        BookDto newBook = new BookDto(null, "Clean Code", "Robert Martin");
        BookDto savedBook = new BookDto(1L, "Clean Code", "Robert Martin");

        Mockito.when(bookServiceMock.addBook(newBook)).thenReturn(savedBook);

        // when
        ResponseEntity<BookDto> response = controller.addBook(newBook);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        BookDto result = response.getBody();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getTitle()).isEqualTo("Clean Code");
        assertThat(result.getAuthor()).isEqualTo("Robert Martin");

        Mockito.verify(bookServiceMock, Mockito.times(1)).addBook(newBook);
    }

    @DisplayName("Should get book by ID")
    @Test
    void shouldGetBookById() {
        // given
        BookDto book = new BookDto(1L, "Hobbit", "Tolkien");
        Mockito.when(bookServiceMock.findById(1L)).thenReturn(Optional.of(book));

        // when
        ResponseEntity<BookDto> response = controller.getBookById(1L);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getTitle()).isEqualTo("Hobbit");
    }

    @DisplayName("Should return NOT_FOUND when book does not exist")
    @Test
    void shouldReturnNotFoundWhenBookDoesNotExist() {
        // given
        Mockito.when(bookServiceMock.findById(999L)).thenReturn(Optional.empty());

        // when
        ResponseEntity<BookDto> response = controller.getBookById(999L);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @DisplayName("Should delete book by ID")
    @Test
    void shouldDeleteBookById() {
        // given
        Mockito.when(bookServiceMock.removeById(1L)).thenReturn(true);

        // when
        ResponseEntity<Void> response = controller.deleteBookById(1L);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @DisplayName("Should return NOT_FOUND when deleting nonexistent book")
    @Test
    void shouldReturnNotFoundWhenDeletingNonexistentBook() {
        // given
        Mockito.when(bookServiceMock.removeById(999L)).thenReturn(false);

        // when
        ResponseEntity<Void> response = controller.deleteBookById(999L);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
