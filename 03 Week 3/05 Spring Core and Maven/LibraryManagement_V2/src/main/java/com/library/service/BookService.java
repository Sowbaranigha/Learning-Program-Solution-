package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private final String prefix;          // injected via constructor
    private BookRepository bookRepository; // injected via setter

    // --- Constructor Injection ---
    public BookService(String prefix) {
        this.prefix = prefix;
    }

    // --- Setter Injection ---
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title) {
        bookRepository.save(prefix + title);
    }
}
