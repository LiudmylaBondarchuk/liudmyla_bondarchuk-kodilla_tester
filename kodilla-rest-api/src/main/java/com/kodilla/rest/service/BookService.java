package com.kodilla.rest.service;

import com.kodilla.rest.domain.BookDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    private final List<BookDto> books = new CopyOnWriteArrayList<>();
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
        BookDto savedBook = new BookDto(idGenerator.getAndIncrement(), bookDto.getTitle(), bookDto.getAuthor());
        books.add(savedBook);
        logger.info("Added book: {}", savedBook);
        return savedBook;
    }

    public boolean removeById(Long id) {
        boolean removed = books.removeIf(book -> book.getId().equals(id));
        if (removed) {
            logger.info("Removed book with ID: {}", id);
        } else {
            logger.warn("Book with ID not found: {}", id);
        }
        return removed;
    }

    public Optional<BookDto> findById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }
}
