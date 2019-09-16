package com.itcluster.advanced.library.controller;

import com.itcluster.advanced.library.model.Book;
import com.itcluster.advanced.library.model.Logbook;
import com.itcluster.advanced.library.model.User;
import com.itcluster.advanced.library.service.BookService;
import com.itcluster.advanced.library.service.LogbookService;
import com.itcluster.advanced.library.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private LogbookService logService;

    @ModelAttribute("user")
    public User activeUser(Authentication authentication) {

        return userService.findUserByEmail(authentication.getName()).get();
    }

    @GetMapping("/random")
    public String randomBook(Model model) {

        List<Book> books = bookService.findAll();
        Random r = new Random();
        Book book = books.get(r.nextInt(books.size()));
        model.addAttribute("book", book);
        return "onebook";
    }

    @GetMapping("/{id}")
    public String homePage(@PathVariable Long id, Model model) {

        model.addAttribute("book", bookService.getOne(id));
        return "onebook";
    }

    @GetMapping("/list")
    public String getBookList(Model model) {

        model.addAttribute("books", bookService.findAll());
        model.addAttribute("status", "all");
        model.addAttribute("title", "Всі книжки в бібліотеці");
        return "books";
    }

    @GetMapping("/available")
    public String getAvailable(Model model) {

        model.addAttribute("books", bookService.getAvailable());
        model.addAttribute("status", "available");
        model.addAttribute("title", "Книжки до видачі");
        return "books";
    }

    @GetMapping("/taken")
    public String getTaken(@ModelAttribute("user") User user,
                           Model model
    ) {
        model.addAttribute("booklogs", logService.findByUserIdAndByReturnedIsNull(user.getId()));
        model.addAttribute("title", "Книжки на руках у читача");
        model.addAttribute("status", "taken");
        return "taken";
    }

    @GetMapping("/take")
    public String take(@RequestParam Long bookId,
                       @ModelAttribute("user") User user
    ) {
        logService.takeBook(user, bookService.getOne(bookId));
        return "forward:/book/available";
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam Long recordId) {

        logService.returnBook(recordId);
        return "forward:/book/taken";
    }
}
