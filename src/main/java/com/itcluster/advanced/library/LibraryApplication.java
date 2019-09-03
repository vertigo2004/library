package com.itcluster.advanced.library;

import com.itcluster.advanced.library.model.Book;
import com.itcluster.advanced.library.model.Genre;
import com.itcluster.advanced.library.model.Publicity;
import com.itcluster.advanced.library.repository.BookRepository;
import com.itcluster.advanced.library.repository.GenreRepository;
import com.itcluster.advanced.library.repository.PublicityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }
}