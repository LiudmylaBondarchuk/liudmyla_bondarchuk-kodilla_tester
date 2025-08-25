package com.kodilla.rest.controller;

import com.kodilla.rest.domain.BookDto;
import com.kodilla.rest.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> books = bookService.getBooks();
        System.out.println("Retrieved books: " + books.size());
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        BookDto book = bookService.findById(id);
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto) {
        System.out.println("Received request to add book: " + bookDto);
        BookDto savedBook = bookService.addBook(bookDto);
        return ResponseEntity.ok(savedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        System.out.println("Received request to delete book with ID: " + id);
        boolean removed = bookService.removeById(id);
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteBook(@RequestBody BookDto bookDto) {
        System.out.println("Received request to delete book: " + bookDto);
        boolean removed = bookService.removeBook(bookDto);
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/by-params")
    public ResponseEntity<Void> deleteByParams(
            @RequestParam String title,
            @RequestParam String author) {
        System.out.println("Received request to delete book - Title: " + title + ", Author: " + author);
        boolean removed = bookService.removeByTitleAndAuthor(title, author);
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/by-path/{title}/{author}")
    public ResponseEntity<Void> deleteByPath(
            @PathVariable String title,
            @PathVariable String author) {
        System.out.println("Received request to delete book by path - Title: " + title + ", Author: " + author);
        boolean removed = bookService.removeByTitleAndAuthor(title, author);
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}