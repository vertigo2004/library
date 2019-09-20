package com.itcluster.advanced.library.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Book")  // 404
@Slf4j
public class BookNotFoundException extends IllegalArgumentException {
    public BookNotFoundException(Long bookID) {
        super("Can't find a book with ID: " + bookID);
    }
}
