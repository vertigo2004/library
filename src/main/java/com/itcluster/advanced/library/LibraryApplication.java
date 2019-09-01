package com.itcluster.advanced.library;

import com.itcluster.advanced.library.model.Book;
import com.itcluster.advanced.library.model.Publicity;
import com.itcluster.advanced.library.repository.BookRepository;
import com.itcluster.advanced.library.repository.PublicityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository bookRepo, PublicityRepository publicityRepo) {
        return (args) -> {
            Publicity p = new Publicity();
            p.setName("А-БА-БА-ГА-ЛА-МА-ГА");
            p = publicityRepo.save(p);

            Book b = new Book();
            b.setAuthor("Дж. К. Ролінг");
            b.setTitle("Гаррі Поттер і філософський камінь");
            b.setGenre("Фентезі");
            b.setPublicity(p);
            b.setPublished("2002");
            bookRepo.save(b);

            b = new Book();
            b.setAuthor("Дж. К. Ролінг");
            b.setTitle("Гаррі Поттер і таємна кімната");
            b.setGenre("Фентезі");
            b.setPublicity(p);
            b.setPublished("2002");
            bookRepo.save(b);

            b = new Book();
            b.setAuthor("Дж. К. Ролінг");
            b.setTitle("Гаррі Поттер і прокляте дитя");
            b.setGenre("Фентезі");
            b.setPublicity(p);
            b.setPublished("2016");
            bookRepo.save(b);

            p = new Publicity();
            p.setName("КСД");
            p = publicityRepo.save(p);

            b = new Book();
            b.setAuthor("К. Р. Сафон");
            b.setTitle("Тінь вітру");
            b.setGenre("Fiction");
            b.setPublicity(p);
            b.setPublished("2017");
            bookRepo.save(b);

            b = new Book();
            b.setAuthor("К. Р. Сафон");
            b.setTitle("Гра янгола");
            b.setGenre("Fiction");
            b.setPublicity(p);
            b.setPublished("2017");
            bookRepo.save(b);

            b = new Book();
            b.setAuthor("К. Р. Сафон");
            b.setTitle("В’язень Неба");
            b.setGenre("Fiction");
            b.setPublicity(p);
            b.setPublished("2017");
            bookRepo.save(b);

            b = new Book();
            b.setAuthor("К. Р. Сафон");
            b.setTitle("Лабіринт духів");
            b.setGenre("Fiction");
            b.setPublicity(p);
            b.setPublished("2018");
            bookRepo.save(b);
        };
    }
}