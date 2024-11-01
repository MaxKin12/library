package com.project.mainservice.mapper;

import com.project.mainservice.dto.BookDto;
import com.project.mainservice.dto.BookListDto;
import com.project.mainservice.dto.BookNoIdDto;
import com.project.mainservice.model.Book;
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
