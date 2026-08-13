package com.ara.BookManager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data              // ترکیبی از @Getter, @Setter, @ToString, @EqualsAndHashCode
@NoArgsConstructor // کانستراکتور بدون پارامتر
@AllArgsConstructor // کانستراکتور با همه پارامترها
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(nullable = false, length = 255)
    private String title;

    @Column(length = 100)
    private String author;

    @Column(precision = 19, scale = 2)
    private BigDecimal price;

    @Column(length = 2000)
    private String description;

}
