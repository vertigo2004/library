package com.itcluster.advanced.library.service;

import com.itcluster.advanced.library.model.Book;
import com.itcluster.advanced.library.model.Logbook;
import com.itcluster.advanced.library.model.User;
import com.itcluster.advanced.library.repository.LogbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LogbookService {

    @Autowired
    private LogbookRepository logbookRepository;

    public Logbook takeBook(User user, Book book) {
        Logbook logbook = new Logbook();
        logbook.setUser(user);
        logbook.setBook(book);
        logbook.setHandout(new Date());
        return logbookRepository.save(logbook);
    }

    public Logbook returnBook(Long recordId) {
        Logbook record = logbookRepository.findById(recordId).get();
        record.setReturned(new Date());
        return logbookRepository.save(record);
    }

    public List<Logbook> findByUserIdAndByReturnedIsNull(Long id) {
        return logbookRepository.findByUserIdAndReturnedIsNull(id);
    }
}
