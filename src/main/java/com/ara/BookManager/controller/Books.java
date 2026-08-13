package com.ara.BookManager.controller;


import com.ara.BookManager.model.Book;
import com.ara.BookManager.model.CreateBook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;

@RestController
public class Books {

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> findById(@PathVariable int id){
        Book book = new Book(79,"about something","A A Adam"
                , BigDecimal.valueOf(50.99),"book description");
        return ResponseEntity.ok(book);
    }

    @PostMapping("/book")
    public ResponseEntity<Book> addBook(@RequestBody CreateBook book){
        int bookId=12;
        return ResponseEntity
                .created(URI.create("/books/" + bookId))
                .body(Book.fromCreateBook(bookId,book));
    }

    @PostMapping("/testDouble")
    public ResponseEntity<Double> testDouble(@RequestParam Double number){
        return ResponseEntity.ok(number+0.2);// 0.1 --> 0.30000000000000004
        //return ResponseEntity.ok(number);// 0.1 --> 0.1 and 0.3 --> 0.3
    }
}
