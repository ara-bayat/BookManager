package com.ara.BookManager.service;

import com.ara.BookManager.dtos.BookDto;

import java.util.List;

public interface BookService {
    BookDto SaveBook(BookDto book);
    List<BookDto> findAllBooks();
    BookDto findBookById(String id);
    BookDto updateBook(BookDto book);
    Long deleteBookById(String id);

}
