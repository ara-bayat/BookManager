package com.ara.BookManager.repository;

import com.ara.BookManager.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InMemoryBookRepository extends JpaRepository<Book,Integer> {
}
