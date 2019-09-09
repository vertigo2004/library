package com.itcluster.advanced.library.controller;

import com.itcluster.advanced.library.model.Book;
import com.itcluster.advanced.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Random;

@Controller
public class BookUiController {

    @Autowired
    BookService bookService;

    @GetMapping("/")
    public String homePage() {
        return "homepage";
    }

    @GetMapping("dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("random-book")
    public String randomBook(Model model) {
        List<Book> books = bookService.findAll();
        Random r = new Random();
        Book book = books.get(r.nextInt(books.size()));
        model.addAttribute("book", book);
        return "onebook";
    }

    @GetMapping("book/{id}")
    public String homePage(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getOne(id));
        return "onebook";
    }

    @GetMapping("book-list")
    public String getBookList(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }
}
