package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository  // Marks this as a repository bean
public class BookRepository {
    public void save(String title) {
        System.out.println("Saving book: " + title);
    }
}
