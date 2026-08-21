package com.ara.BookManager.repository.book;


import com.ara.BookManager.model.BookEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {
    BookEntity save(BookEntity book);
    List<BookEntity> findAll();
    BookEntity findBookById(String id);
    BookEntity updateBook(BookEntity book);
    long deleteBookById(String id);
}
