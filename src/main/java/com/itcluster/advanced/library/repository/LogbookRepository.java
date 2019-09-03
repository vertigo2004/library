package com.itcluster.advanced.library.repository;

import com.itcluster.advanced.library.model.Logbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogbookRepository extends JpaRepository<Logbook, Long> {
    List<Logbook> findByUserId(Long id);
    List<Logbook> findByBookId(Long id);
    @Query("SELECT l from Logbook l where l.returned is null ")
    List<Logbook> findNotReturned();
}
