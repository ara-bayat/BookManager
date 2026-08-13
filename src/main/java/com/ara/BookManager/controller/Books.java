package com.ara.BookManager.controller;


import com.ara.BookManager.model.Book;
import com.ara.BookManager.model.CreateBook;
import com.ara.BookManager.repository.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class Books {




    private final BookRepo bookRepo;

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> findById(@PathVariable int id){
//        return bookRepo.findBookById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());

        return ResponseEntity.of(bookRepo.findBookById(id));
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
