package com.project.mainservice.controllers;

import com.project.mainservice.dtos.BookDto;
import com.project.mainservice.dtos.BookListDto;
import com.project.mainservice.dtos.BookNoIdDto;
import com.project.mainservice.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/books")
@RestController
@RequiredArgsConstructor
public class MainServiceController {
    private final BookService bookService;

    @GetMapping("")
    public ResponseEntity<BookListDto> getAllBooks() {
        BookListDto bookListDto = bookService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(bookListDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable("id") Long bookId) {
        BookDto bookDto = bookService.findById(bookId);
        return ResponseEntity.status(HttpStatus.OK).body(bookDto);
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookDto> getBook(@PathVariable("isbn") String isbn) {
        BookDto bookDto = bookService.findByIsbn(isbn);
        return ResponseEntity.status(HttpStatus.OK).body(bookDto);
    }

    @PostMapping("/")
    public ResponseEntity<BookDto> createBook(@RequestBody BookNoIdDto bookNoIdDto) {
        BookDto bookDto = bookService.create(bookNoIdDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookNoIdDto bookNoIdDto,
                              @PathVariable("id") Long bookId) {
        BookDto bookDto = bookService.update(bookNoIdDto, bookId);
        return ResponseEntity.status(HttpStatus.OK).body(bookDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long bookId) {
        bookService.delete(bookId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
