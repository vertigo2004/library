package com.itcluster.advanced.library.repository;

import com.itcluster.advanced.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthorLastnameLike(String lastname);
    List<Book> findByPublished(String published);
    List<Book> findByPublicityName(String pubName);
    List<Book> findByGenreName(String genre);

}
