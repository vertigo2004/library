package com.itcluster.advanced.library.service;

import com.itcluster.advanced.library.model.Author;
import com.itcluster.advanced.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepo;

    public List<Author> getByLastname(String lastname) {
        return authorRepo.findByLastnameLikeOrderByFirstnameAscMiddlenameAsc(lastname);
    }

    public Author create(Author author) {
        return authorRepo.save(author);
    }

    public List<Author> getAll() {
        return authorRepo.findAll();
    }

}
