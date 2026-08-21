package com.ara.BookManager.dtos;

import com.ara.BookManager.model.BookEntity;
import org.bson.types.ObjectId;

import java.math.BigDecimal;

public record BookDto(
        String id,
        String title,
        String author,
        BigDecimal price,
        String description) {
    public BookDto(BookEntity input){
        this(input.getId()==null?new ObjectId().toHexString():
                input.getId().toHexString(),input.getTitle(),
                input.getAuthor(),input.getPrice(),input.getDescription());
    }

    public BookEntity toEntity(){
        ObjectId _id = id==null? new ObjectId():new ObjectId(id);
        return new BookEntity(_id, title, author, price, description);
    }


}
