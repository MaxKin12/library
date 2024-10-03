package com.project.mainservice.controllers;

import com.project.mainservice.clients.AdditionalServiceClient;
import com.project.mainservice.dtos.BookDto;
import com.project.mainservice.dtos.BookNoIdDto;
import com.project.mainservice.mappers.BookMapper;
import com.project.mainservice.models.Book;
import com.project.mainservice.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainServiceController {
    private final BookMapper bookMapper;
    private final BookService bookService;
    private final AdditionalServiceClient client;

    @GetMapping("/")
    public List<BookDto> getAllBooks() {
        List<Book> books = bookService.findAll();
        return bookMapper.toListDto(books);
    }

    @GetMapping("/{id}")
    public BookDto getBook(@PathVariable("id") Long bookId) {
        Book book = bookService.findById(bookId);
        return bookMapper.toDto(book);
    }

    @GetMapping("/isbn/{isbn}")
    public BookDto getBook(@PathVariable("isbn") String isbn) {
        Book book = bookService.findByIsbn(isbn);
        return bookMapper.toDto(book);
    }

    @PostMapping("/create")
    public ResponseEntity<BookDto> createBook(@RequestBody BookNoIdDto bookNoIdDto) {
        Book book = bookService.create(bookMapper.toNoIdModel(bookNoIdDto));
        client.addRecord(book.getId());
        return ResponseEntity.status(HttpStatus.OK).body(bookMapper.toDto(book));
    }

    @PostMapping("/update/{id}")
    public BookDto updateBook(@RequestBody BookNoIdDto bookNoIdDto,
                              @PathVariable("id") Long bookId) {
        Book book = bookService.update(bookMapper.toNoIdModel(bookNoIdDto), bookId);
        return bookMapper.toDto(book);
    }

    @PostMapping("/delete/{id}")
    public void deleteBook(@PathVariable("id") Long bookId) {
        bookService.delete(bookId);
    }
}
