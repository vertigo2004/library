package com.itcluster.advanced.library.controller;

import com.itcluster.advanced.library.model.Book;
import com.itcluster.advanced.library.model.Publicity;
import com.itcluster.advanced.library.repository.BookRepository;

import com.itcluster.advanced.library.repository.PublicityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("book")
@Slf4j
public class BookController {

    BookRepository bookRepository;
    PublicityRepository pubRepository;

    public BookController(BookRepository bookRepository,
                          PublicityRepository pubRepository) {
        this.bookRepository = bookRepository;
        this.pubRepository = pubRepository;
    }

    @GetMapping("{id}")
    public Book getOne(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @GetMapping("all")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @PostMapping(produces = "application/json")
    public Book save(@RequestBody Book book) {
        String name = book.getPublicity().getName();
        if (!StringUtils.isEmpty(name)) {
            Publicity pub = pubRepository.getByName(name);
            if (pub != null) {
                book.setPublicity(pub);
            } else {
                book.setPublicity(pubRepository.save(book.getPublicity()));
            }
        }

        return bookRepository.save(book);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        Optional<Book> toDelete = bookRepository.findById(id);
        if (toDelete.isPresent()) {
            bookRepository.delete(toDelete.get());
        }
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
