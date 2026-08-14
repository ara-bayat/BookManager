package com.ara.BookManager.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BookNotFound extends Exception {
    private final Integer bookId;  // پارامتر اضافی

    public BookNotFound(Integer bookId) {
        super("Book with id " + bookId + " not found");
        this.bookId = bookId;
    }

    public Integer getBookId() { return bookId; }
}
