package com.project.mainservice.services;

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
        Book oldBook = bookRepository.findById(oldBookId).get();
        oldBook.setIsbn(editedBook.getIsbn());
        oldBook.setTitle(editedBook.getTitle());
        oldBook.setGenre(editedBook.getGenre());
        oldBook.setDescription(editedBook.getDescription());
        oldBook.setDescription(editedBook.getAuthor());
        return oldBook;
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
