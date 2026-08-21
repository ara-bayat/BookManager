package com.ara.BookManager.repository;

import com.ara.BookManager.model.BookEntity;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@Repository
@RequiredArgsConstructor
public class MongoDbBookRepository implements BookRepository {
    private final MongoClient client;
    private MongoCollection<BookEntity> bookCollection;

    @PostConstruct
    public void init(){
        bookCollection=client.getDatabase("bookStore").getCollection("books",BookEntity.class);
    }

    @Override
    public BookEntity save(BookEntity book) {
        book.setId(new ObjectId());
        bookCollection.insertOne(book);
        return book;
    }

    @Override
    public List<BookEntity> findAll() {
        return bookCollection.find().into(new ArrayList<>());
    }

    @Override
    public BookEntity findBookById(String id) {
        return bookCollection.find(eq("_id",new ObjectId(id))).first();
    }

    @Override
    public BookEntity updateBook(BookEntity book) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
        return bookCollection.findOneAndReplace(eq("_id",book.getId()),book,options);
    }

    @Override
    public long deleteBookById(String id) {
        return bookCollection.deleteOne(eq("_id",new ObjectId(id))).getDeletedCount();
    }
}
