package com.ara.BookManager.model;

import java.math.BigDecimal;

public record Book(int id, String title, String author,
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
