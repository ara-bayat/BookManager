package com.ara.BookManager.controller;

import com.ara.BookManager.dtos.BookDto;
import com.ara.BookManager.dtos.UserDto;
import com.ara.BookManager.service.book.BookService;
import com.ara.BookManager.service.user.UserService;
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
@RequestMapping("/api/v1/users")
public class MongoDbUserController {
    private final UserService userService;



    @GetMapping("/")
    public ResponseEntity<List<UserDto>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findBookById(@PathVariable String id){
        UserDto userDto = userService.findById(id);
        if(userDto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(userDto);
    }

    @PutMapping()
    public ResponseEntity<UserDto> updateBookById(@Valid @RequestBody UserDto userDto){
        var updatedUser=userService.update(userDto);
        if(updatedUser == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable String id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
