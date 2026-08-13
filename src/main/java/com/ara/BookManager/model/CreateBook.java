package com.ara.BookManager.model;

import java.math.BigDecimal;

public record CreateBook(String title, String author,
                         BigDecimal price, String description) {
}
