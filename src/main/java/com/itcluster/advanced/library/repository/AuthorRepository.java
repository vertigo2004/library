package com.itcluster.advanced.library.repository;

import com.itcluster.advanced.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByLastnameOrderByFirstnameMiddlename(String name);
}
