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

    @Bean
    public CommandLineRunner demo(BookRepository bookRepo, PublicityRepository publicityRepo, GenreRepository genreRepo) {
        return (args) -> {
            Publicity p = new Publicity();
            p.setName("А-БА-БА-ГА-ЛА-МА-ГА");
            p = publicityRepo.save(p);

            Set<Genre> genreSet = new HashSet<>();

            Genre g = new Genre();
            g.setName("Фентезі");
            g = genreRepo.save(g);
            genreSet.add(g);

            g = new Genre();
            g.setName("Дитяча");
            g = genreRepo.save(g);
            genreSet.add(g);

            Book b = new Book();
            b.setAuthor("Дж. К. Ролінг");
            b.setTitle("Гаррі Поттер і філософський камінь");
            b.setGenre(genreSet);
            b.setPublicity(p);
            b.setPublished("2002");
            bookRepo.save(b);

            b = new Book();
            b.setAuthor("Дж. К. Ролінг");
            b.setTitle("Гаррі Поттер і таємна кімната");
            b.setGenre(genreSet);
            b.setPublicity(p);
            b.setPublished("2002");
            bookRepo.save(b);

            b = new Book();
            b.setAuthor("Дж. К. Ролінг");
            b.setTitle("Гаррі Поттер і прокляте дитя");
            b.setGenre(genreSet);
            b.setPublicity(p);
            b.setPublished("2016");
            bookRepo.save(b);

            p = new Publicity();
            p.setName("КСД");
            p = publicityRepo.save(p);

            genreSet = new HashSet<>();

            g = new Genre();
            g.setName("Fiction");
            g = genreRepo.save(g);
            genreSet.add(g);

            b = new Book();
            b.setAuthor("К. Р. Сафон");
            b.setTitle("Тінь вітру");
            b.setGenre(genreSet);
            b.setPublicity(p);
            b.setPublished("2017");
            bookRepo.save(b);

            b = new Book();
            b.setAuthor("К. Р. Сафон");
            b.setTitle("Гра янгола");
            b.setGenre(genreSet);
            b.setPublicity(p);
            b.setPublished("2017");
            bookRepo.save(b);

            b = new Book();
            b.setAuthor("К. Р. Сафон");
            b.setTitle("В’язень Неба");
            b.setGenre(genreSet);
            b.setPublicity(p);
            b.setPublished("2017");
            bookRepo.save(b);

            b = new Book();
            b.setAuthor("К. Р. Сафон");
            b.setTitle("Лабіринт духів");
            b.setGenre(genreSet);
            b.setPublicity(p);
            b.setPublished("2018");
            bookRepo.save(b);
        };
    }
}