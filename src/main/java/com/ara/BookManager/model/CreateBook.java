package com.ara.BookManager.model;

import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

public record CreateBook(@NotEmpty String title, String author,
                         BigDecimal price, String description) {
}
