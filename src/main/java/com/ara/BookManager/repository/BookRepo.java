package com.ara.BookManager.repository;


import com.ara.BookManager.model.Book;
import com.ara.BookManager.model.CreateBook;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepo {
    static int lastId=1;

    private List<Book> books=new ArrayList<>();

    @PostConstruct
    private void init(){
        books.add(new Book(1,"about something","A A Adam"
                , BigDecimal.valueOf(50.99),"book description"));
    }

    public Optional<Book> findBookById(int id){
        return books.stream().filter(item->item.id()==id).findFirst();
    }

    public Boolean deleteBookById(int id){
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).id() == id) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Book> getAllBooks(){
        return books;
    }

    public Book addBook(CreateBook input){
        var book= Book.fromCreateBook(++lastId,input);
        books.add(book);
        return book;
    }


    public Boolean editBook(CreateBook input,int id){
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).id() == id) {
                books.set(i, Book.fromCreateBook(id, input));
                return true;
            }
        }
        return false;

    }
}
