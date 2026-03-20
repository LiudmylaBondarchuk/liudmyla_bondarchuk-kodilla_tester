package com.kodilla.collections.adv.immutable;

import java.util.Objects;

public class Book {
    private final String author;
    private final String title;

    public Book(String author, String title) {
        Objects.requireNonNull(author, "author must not be null");
        Objects.requireNonNull(title, "title must not be null");
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title);
    }

    @Override
    public String toString() {
        return "Book{author='" + author + "', title='" + title + "'}";
    }
}
