package com.itcluster.advanced.library.controller;

import com.itcluster.advanced.library.model.Book;
import com.itcluster.advanced.library.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("book")
@Slf4j
public class BookController {

    BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("{id}")
    public Book getOne(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @GetMapping("all")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @PostMapping()
    public Book save(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("{id}")
    public Book delete(@PathVariable Long id) {
        Book toDelete = bookRepository.findById(id).orElse(null);
        if (toDelete != null) {
            bookRepository.delete(toDelete);
        }
        return toDelete;
    }

    @GetMapping("author/{author}")
    public List<Book> byAuthor(@PathVariable String author) {
        return bookRepository.findByAuthorLike("%" + author + "%");
    }

    @GetMapping("pub/{name}")
    public List<Book> byPublicity(@PathVariable String name) {
        return bookRepository.findByPublicityName(name);
    }
}
