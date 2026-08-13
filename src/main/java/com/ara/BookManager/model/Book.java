package com.ara.BookManager.model;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;

public record Book(int id,
                   @NotEmpty String title, String author,
                   BigDecimal price, String description) {
    public static Book fromCreateBook(int id, CreateBook createBook) {
        return new Book(
                id,
                createBook.title(),
                createBook.author(),
                createBook.price(),
                createBook.description()
        );
    }
}
