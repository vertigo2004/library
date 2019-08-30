package com.itcluster.advanced.library;

import com.itcluster.advanced.library.model.Book;
import com.itcluster.advanced.library.repository.BookRepository;
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
    public CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
            // save a couple of customers
            Book b = new Book();
            b.setAuthor("Дж. К. Ролінг");
            b.setTitle("Гаррі Поттер і філософський камінь");
            b.setGenre("Фентезі");
            b.setPublicity("А-БА-БА-ГА-ЛА-МА-ГА");
            b.setPublished("2002");
            repository.save(b);

            b = new Book();
            b.setAuthor("Дж. К. Ролінг");
            b.setTitle("Гаррі Поттер і таємна кімната");
            b.setGenre("Фентезі");
            b.setPublicity("А-БА-БА-ГА-ЛА-МА-ГА");
            b.setPublished("2002");
            repository.save(b);

            b = new Book();
            b.setAuthor("Дж. К. Ролінг");
            b.setTitle("Гаррі Поттер і прокляте дитя");
            b.setGenre("Фентезі");
            b.setPublicity("А-БА-БА-ГА-ЛА-МА-ГА");
            b.setPublished("2016");
            repository.save(b);

        };
    }
}