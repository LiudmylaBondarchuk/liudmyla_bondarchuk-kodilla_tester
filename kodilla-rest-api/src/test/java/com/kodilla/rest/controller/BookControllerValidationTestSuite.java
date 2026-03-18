package com.kodilla.rest.controller;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@SpringBootTest
@DisplayName("BookController Validation Tests")
class BookControllerValidationTestSuite {

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    void setup() {
        RestAssuredMockMvc.webAppContextSetup(context);
    }

    @Test
    @DisplayName("should return 400 when title is blank")
    void shouldReturn400WhenTitleIsBlank() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"title\":\"\",\"author\":\"Author\"}")
                .when()
                .post("/books")
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("should return 400 when author is blank")
    void shouldReturn400WhenAuthorIsBlank() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"title\":\"Title\",\"author\":\"\"}")
                .when()
                .post("/books")
                .then()
                .statusCode(400);
    }
}
