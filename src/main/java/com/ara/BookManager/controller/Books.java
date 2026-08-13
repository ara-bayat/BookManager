package com.ara.BookManager.controller;


import com.ara.BookManager.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Books {

    @GetMapping("/books/{id}")
    public Book findById(@PathVariable int id){
        Book book = new Book(79,"about something","A A Adam"
                ,50.99,"book description");
        return book;
    }
}
