package com.kodilla.rest.service;
import com.kodilla.rest.domain.BookDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {
    private final List<BookDto> books = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public BookService() {
        books.add(new BookDto(idGenerator.getAndIncrement(), "Hobbit", "Tolkien"));
        books.add(new BookDto(idGenerator.getAndIncrement(), "1984", "Orwell"));
        books.add(new BookDto(idGenerator.getAndIncrement(), "Dune", "Herbert"));
    }

    public List<BookDto> getBooks() {
        return new ArrayList<>(books);
    }

    public BookDto addBook(BookDto bookDto) {
        bookDto.setId(idGenerator.getAndIncrement());
        books.add(bookDto);
        System.out.println("Added book: " + bookDto);
        return bookDto;
    }

    public boolean removeBook(BookDto bookDto) {
        boolean removed = books.remove(bookDto);
        if (removed) {
            System.out.println("Removed book: " + bookDto);
        } else {
            System.out.println("Book not found for removal: " + bookDto);
        }
        return removed;
    }

    public boolean removeById(Long id) {
        boolean removed = books.removeIf(book -> book.getId().equals(id));
        if (removed) {
            System.out.println("Removed book with ID: " + id);
        } else {
            System.out.println("Book with ID not found: " + id);
        }
        return removed;
    }

    public boolean removeByTitleAndAuthor(String title, String author) {
        BookDto bookToRemove = new BookDto(title, author);
        return removeBook(bookToRemove);
    }

    public BookDto findById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}