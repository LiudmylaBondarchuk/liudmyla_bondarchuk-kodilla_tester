package com.kodilla.rest.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Tag("integration")
public class ExternalApiRestAssuredTestSuite {

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
