package com.project.mainservice.mappers;

import com.project.mainservice.dtos.BookDto;
import com.project.mainservice.dtos.BookListDto;
import com.project.mainservice.dtos.BookNoIdDto;
import com.project.mainservice.models.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto toDto(Book book);
    Book toNoIdModel(BookNoIdDto dto);
    List<BookDto> toListDto(List<Book> bookList);
    default BookListDto toBookListDto(List<Book> bookList) {
        return new BookListDto(toListDto(bookList));
    }
}
