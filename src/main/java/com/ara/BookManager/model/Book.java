package com.ara.BookManager.model;

public record Book(int id, String title, String author,
                   double price, String description) {
}
