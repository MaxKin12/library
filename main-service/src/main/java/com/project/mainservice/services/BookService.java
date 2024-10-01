package com.project.mainservice.services;

import com.project.mainservice.dtos.BookDto;
import com.project.mainservice.models.Book;
import com.project.mainservice.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).orElse(null);
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public Book update(Book editedBook, Long oldBookId) {
        editedBook.setId(oldBookId);
        return bookRepository.save(editedBook);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
