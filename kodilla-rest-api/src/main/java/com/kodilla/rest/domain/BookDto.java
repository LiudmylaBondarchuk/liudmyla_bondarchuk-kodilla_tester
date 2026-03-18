package com.kodilla.rest.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public class BookDto {
    private final Long id;

    @NotBlank(message = "Title must not be blank")
    private final String title;

    @NotBlank(message = "Author must not be blank")
    private final String author;

    @JsonCreator
    public BookDto(
            @JsonProperty("id") Long id,
            @JsonProperty("title") String title,
            @JsonProperty("author") String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public BookDto(String title, String author) {
        this(null, title, author);
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto that = (BookDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author);
    }

    @Override
    public String toString() {
        return "BookDto{id=" + id + ", title='" + title + "', author='" + author + "'}";
    }
}
