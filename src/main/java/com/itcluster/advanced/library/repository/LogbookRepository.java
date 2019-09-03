package com.itcluster.advanced.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LogbookRepository extends JpaRepository<LogbookRepository, Long> {
    List<LogbookRepository> findByUserId(Long id);
    List<LogbookRepository> findByBookId(Long id);
    @Query("SELECT l from LogbookRepository l where l.returned is null ")
    List<LogbookRepository> findNotReturned();
}
