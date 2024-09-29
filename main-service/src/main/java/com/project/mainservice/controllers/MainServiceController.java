package com.project.mainservice.controllers;

import com.project.mainservice.dtos.BookDto;
import com.project.mainservice.mappers.BookMapper;
import com.project.mainservice.models.Book;
import com.project.mainservice.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainServiceController {
    private final BookMapper bookMapper;
    private final BookService bookService;

    @GetMapping("/books/{id}")
    public BookDto getBook(@PathVariable("id") Long bookId) {
        Book book = bookService.findById(bookId);
        return bookMapper.toDto(book);
    }
}
