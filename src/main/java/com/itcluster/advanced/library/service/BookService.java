package com.itcluster.advanced.library.service;

import com.itcluster.advanced.library.model.Author;
import com.itcluster.advanced.library.model.Book;
import com.itcluster.advanced.library.model.Genre;
import com.itcluster.advanced.library.model.Publicity;
import com.itcluster.advanced.library.repository.AuthorRepository;
import com.itcluster.advanced.library.repository.BookRepository;
import com.itcluster.advanced.library.repository.GenreRepository;
import com.itcluster.advanced.library.repository.PublicityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    PublicityRepository pubRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    GenreRepository genreRepository;

    public Book getOne(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    private Set<Author> resolveAuthors(Set<Author> authors) {
        Set<Author> resolved = new HashSet<>(authors.size());
        for (Author author : authors) {

            Author a = authorRepository.findByFirstnameAndLastname(
                    author.getFirstname(),
                    author.getLastname());
            if (a == null) {
                a = authorRepository.save(author);
            }
            resolved.add(a);
        }
        return resolved;
    }

    private Set<Genre> resolveGenre(Set<Genre> genres) {
        Set<Genre> resolved = new HashSet<>(genres.size());
        for (Genre genre : genres) {
            Genre g = genreRepository.findByName(genre.getName());
            if (g == null) {
                g = genreRepository.save(genre);
            }
            resolved.add(g);
        }
        return resolved;
    }

    public void delete(Long id) {
        Optional<Book> toDelete = bookRepository.findById(id);
        if (toDelete.isPresent()) {
            bookRepository.delete(toDelete.get());
        }
    }

    public List<Book> getByAuthor(String author) {
        return bookRepository.findByAuthorLastnameLike("%" + author + "%");
    }

    public List<Book> getByPublicity(String name) {
        return bookRepository.findByPublicityName(name);
    }
}
