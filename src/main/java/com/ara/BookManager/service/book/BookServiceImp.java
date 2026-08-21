package com.ara.BookManager.service.book;

import com.ara.BookManager.dtos.BookDto;
import com.ara.BookManager.repository.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImp implements BookService {
    private final BookRepository bookRepository;

    @Override
    public BookDto SaveBook(BookDto book) {
        return new BookDto(bookRepository.save(book.toEntity()));
    }

    @Override
    public List<BookDto> findAllBooks() {
        return bookRepository.findAll().stream()
                .map(BookDto::new).toList();
    }

    @Override
    public BookDto findBookById(String id) {
        return new BookDto(bookRepository.findBookById(id));
    }

    @Override
    public BookDto updateBook(BookDto book) {
        return new BookDto(bookRepository
                .updateBook(book.toEntity()));
    }

    @Override
    public Long deleteBookById(String id) {
        return bookRepository.deleteBookById(id);
    }
}
