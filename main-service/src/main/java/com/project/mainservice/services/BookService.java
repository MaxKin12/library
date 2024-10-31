package com.project.mainservice.services;

import com.project.mainservice.clients.AdditionalServiceClient;
import com.project.mainservice.dtos.BookDto;
import com.project.mainservice.dtos.BookListDto;
import com.project.mainservice.dtos.BookNoIdDto;
import com.project.mainservice.exceptions.DBException;
import com.project.mainservice.exceptions.ResourceNotFoundException;
import com.project.mainservice.mappers.BookMapper;
import com.project.mainservice.models.Book;
import com.project.mainservice.repositories.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AdditionalServiceClient client;

    public BookListDto findAll() {
        List<Book> books = bookRepository.findAll();
        return bookMapper.toBookListDto(books);
    }

    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book with id " +
                id + " not found"));
        return bookMapper.toDto(book);
    }

    public BookDto findByIsbn(String isbn) {
        Book book = bookRepository.findByIsbn(isbn).orElseThrow(()-> new ResourceNotFoundException("Book with isbn " +
                isbn + " not found"));
        return bookMapper.toDto(book);
    }

    @Transactional
    public BookDto create(BookNoIdDto bookDto) {
        try {
            Book book = bookRepository.save(bookMapper.toNoIdModel(bookDto));
            client.createRecord(book.getId());
            return bookMapper.toDto(book);
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

    @Transactional
    public BookDto update(BookNoIdDto editedBookDto, Long oldBookId) {
        Book book = bookRepository.findById(oldBookId)
                .orElseThrow(()-> new ResourceNotFoundException("Book with id " + oldBookId + " not found"));
        try {
            book.setIsbn(editedBookDto.isbn());
            book.setTitle(editedBookDto.title());
            book.setGenre(editedBookDto.genre());
            book.setDescription(editedBookDto.description());
            book.setAuthor(editedBookDto.author());
            return bookMapper.toDto(book);
        } catch (Exception e) {
            throw new DBException("Invalid attempt to update book");
        }
    }

    public void delete(Long id) {
        try {
            bookRepository.deleteById(id);
        } catch (Exception e) {
            throw new DBException(e);
        }
    }
}
