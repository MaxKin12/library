package com.project.mainservice.services;

import com.project.mainservice.exceptions.DBException;
import com.project.mainservice.exceptions.ResourceNotFoundException;
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
        return bookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book with id " +
                id + " not found"));
    }

    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow(()-> new ResourceNotFoundException("Book with isbn " +
                isbn + " not found"));
    }

    public Book create(Book book) {
        try {
            return bookRepository.save(book);
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

    public Book update(Book editedBook, Long oldBookId) {
        bookRepository.findById(oldBookId).orElseThrow(()-> new ResourceNotFoundException("Record with id " +
                oldBookId + " not found"));
        bookRepository.updateRecordInfoByBookId(
                oldBookId,
                editedBook.getIsbn(),
                editedBook.getTitle(),
                editedBook.getGenre(),
                editedBook.getDescription(),
                editedBook.getAuthor()
        );
        return bookRepository.findById(oldBookId).orElseThrow(()-> new DBException("Invalid attempt to update user"));
    }

    public void delete(Long id) {
        try {
            bookRepository.deleteById(id);
        } catch (Exception e) {
            throw new DBException(e);
        }
    }
}
