package com.ara.BookManager.controller;

import com.ara.BookManager.model.Book;
import com.ara.BookManager.repository.InMemoryBookRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class InMemoryBookController {
    private final InMemoryBookRepository bookRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Book> findById(@PathVariable int id) {
        return bookRepository.findById(id);
    }


    @PutMapping("/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Book update(
            @PathVariable int id,
            @Valid @RequestBody Book bookDetails) {
        Book book= bookRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setDescription(bookDetails.getDescription());
        book.setPrice(bookDetails.getPrice());
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        bookRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        bookRepository.deleteById(id);
    }


}
