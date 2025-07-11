package com.library.controller;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository repo;
    public BookController(BookRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Book> all() { return repo.findAll(); }

    @PostMapping
    public Book create(@RequestBody Book book) { return repo.save(book); }

    @GetMapping("/{id}")
    public ResponseEntity<Book> one(@PathVariable Long id) {
        return repo.findById(id)
                   .map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repo.deleteById(id); }
}
