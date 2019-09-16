package com.itcluster.advanced.library.rest.v1;

import com.itcluster.advanced.library.model.Book;

import com.itcluster.advanced.library.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/book")
@Slf4j
public class BookRestController {

    @Autowired
    BookService bookService;

    @GetMapping("{id}")
    public Book getOne(@PathVariable Long id) {
        return bookService.getOne(id);
    }

    @GetMapping("all")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @PostMapping(produces = "application/json")
    public Book save(@RequestBody Book book) {
        return bookService.create(book);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @GetMapping("author/{author}")
    public List<Book> byAuthor(@PathVariable String author) {
        return bookService.getByAuthor(author);
    }

    @GetMapping("pub/{name}")
    public List<Book> byPublicity(@PathVariable String name) {
        return bookService.getByPublicity(name);
    }
}
