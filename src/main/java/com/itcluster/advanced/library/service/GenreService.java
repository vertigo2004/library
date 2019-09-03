package com.itcluster.advanced.library.service;

import com.itcluster.advanced.library.model.Genre;
import com.itcluster.advanced.library.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepo;

    public List<Genre> getAll() {
        return genreRepo.findAll();
    }

    public Genre create(Genre genre) {
        return genreRepo.save(genre);
    }
}
