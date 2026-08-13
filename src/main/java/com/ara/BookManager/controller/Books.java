package com.ara.BookManager.controller;


import com.ara.BookManager.model.Book;
import com.ara.BookManager.model.CreateBook;
import com.ara.BookManager.repository.BookRepo;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
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

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        if(bookRepo.deleteBookById(id)){
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAll(){
//        return bookRepo.findBookById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());

        return ResponseEntity.ok(bookRepo.getAllBooks());
    }

    @PostMapping("/book")
    public ResponseEntity<Book> addBook(
           @Valid @RequestBody CreateBook book){
        Book result=bookRepo.addBook(book);
        return ResponseEntity
                .created(URI.create("/books/" + result.id()))
                .body(result);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Void> editBook(
            @Valid @RequestBody CreateBook book,
            @PathVariable int id){
        if(bookRepo.editBook(book,id)){
            return ResponseEntity
                    .noContent()
                    .build();
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @PostMapping("/testDouble")
    public ResponseEntity<Double> testDouble(@RequestParam Double number){
        return ResponseEntity.ok(number+0.2);// 0.1 --> 0.30000000000000004
        //return ResponseEntity.ok(number);// 0.1 --> 0.1 and 0.3 --> 0.3
    }
}
