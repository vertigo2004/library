package com.itcluster.advanced.library.repository;

import com.itcluster.advanced.library.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
