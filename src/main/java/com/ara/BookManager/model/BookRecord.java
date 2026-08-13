package com.ara.BookManager.model;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;

public record BookRecord(int id,
                         @NotEmpty String title, String author,
                         BigDecimal price, String description) {
    public static BookRecord fromCreateBook(int id, CreateBook createBook) {
        return new BookRecord(
                id,
                createBook.title(),
                createBook.author(),
                createBook.price(),
                createBook.description()
        );
    }
}
