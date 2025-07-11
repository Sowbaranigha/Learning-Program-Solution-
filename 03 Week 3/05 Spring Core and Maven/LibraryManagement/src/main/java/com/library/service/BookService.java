package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;        // dependency

    // Setter for Spring to inject
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Simple method to prove injection works
    public void addBook(String title) {
        bookRepository.save(title);
    }
}
