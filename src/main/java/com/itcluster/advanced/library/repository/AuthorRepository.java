package com.itcluster.advanced.library.repository;

import com.itcluster.advanced.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByLastnameOrderByFirstnameMiddlename(String name);
}
