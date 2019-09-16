package com.itcluster.advanced.library.repository;

import com.itcluster.advanced.library.model.Book;
import com.itcluster.advanced.library.model.Logbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogbookRepository extends JpaRepository<Logbook, Long> {
    List<Logbook> findByUserId(Long id);
    List<Logbook> findByBookId(Long id);

    List<Logbook> findByUserIdAndReturnedIsNull(Long id);

    @Query("SELECT l.book from Logbook l where l.returned is null ")
    List<Book> findNotReturned();

    @Query("SELECT l.book from Logbook l where l.returned is null and l.user.id = :userId")
    List<Book> findTakenByUser(Long userId);


}
