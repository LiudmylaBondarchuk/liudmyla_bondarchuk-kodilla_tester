package com.kodilla.rest.controller;

import com.kodilla.rest.domain.BookDto;
import com.kodilla.rest.service.BookService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.when;

@ExtendWith(MockitoExtension.class)
class BookControllerRestAssuredTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    public void initialiseRestAssuredMockMvcStandalone() {
        RestAssuredMockMvc.standaloneSetup(bookController);
    }

    @Test
    void shouldFetchBooks() {
        Mockito.when(bookService.getBooks())
                .thenReturn(List.of(
                        new BookDto("Title 1", "Author 1"),
                        new BookDto("Title 2", "Author 2"))
                );

        when()
                .get("/books")
                .then()
                .body("$.size()", Matchers.equalTo(2))
                .body("[0].title", Matchers.equalTo("Title 1"))
                .body("[0].author", Matchers.equalTo("Author 1"))
                .body("[1].title", Matchers.equalTo("Title 2"))
                .body("[1].author", Matchers.equalTo("Author 2"))
                .status(HttpStatus.OK);
    }

    @Test
    void shouldAddBook() {
        BookDto newBook = new BookDto(null, "Clean Code", "Robert Martin");
        BookDto savedBook = new BookDto(1L, "Clean Code", "Robert Martin");

        Mockito.when(bookService.addBook(newBook)).thenReturn(savedBook);

        given()
                .contentType(ContentType.JSON)
                .body(newBook)
                .when()
                .post("/books")
                .then()
                .status(HttpStatus.OK)
                .body("id", Matchers.equalTo(1))
                .body("title", Matchers.equalTo("Clean Code"))
                .body("author", Matchers.equalTo("Robert Martin"));
    }

    @Test
    void shouldUpdateExternalPost() {
        Map<String, Object> updatedPost = new HashMap<>();
        updatedPost.put("id", 1);
        updatedPost.put("title", "Updated title");

        given()
                .header("Content-Type", "application/json")
                .body(updatedPost)
                .when()
                .put("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200)
                .body("id", Matchers.equalTo(1))
                .body("title", Matchers.equalTo("Updated title"));
    }
}