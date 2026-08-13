package com.ara.BookManager.repository;


import com.ara.BookManager.model.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepo {

    private List<Book> books=new ArrayList<>();

    @PostConstruct
    private void init(){
        books.add(new Book(1,"about something","A A Adam"
                , BigDecimal.valueOf(50.99),"book description"));
    }

    public Optional<Book> findBookById(int id){
        return books.stream().filter(item->item.id()==id).findFirst();
    }
}
