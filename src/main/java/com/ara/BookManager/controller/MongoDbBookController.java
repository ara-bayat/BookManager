package com.ara.BookManager.controller;

import com.ara.BookManager.dtos.BookDto;
import com.ara.BookManager.model.BookEntity;
import com.ara.BookManager.repository.BookRepository;
import com.ara.BookManager.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class MongoDbBookController {
    private final BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto,
                                              UriComponentsBuilder uriComponentsBuilder) {
        var savedook= bookService.SaveBook(bookDto);
        URI location = uriComponentsBuilder.path("/api/v1/books/{id}")
                .buildAndExpand(savedook.id()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<BookDto>> findAll(){
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> findBookById(@PathVariable String id){
        BookDto bookDto = bookService.findBookById(id);
        if(bookDto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(bookDto);
    }

    @PutMapping()
    public ResponseEntity<BookDto> updateBookById(@Valid @RequestBody BookDto bookDto){
        var updatedBook=bookService.updateBook(bookDto);
        if(updatedBook == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable String id){
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }
}
