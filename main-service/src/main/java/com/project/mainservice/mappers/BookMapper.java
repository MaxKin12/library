package com.project.mainservice.mappers;

import com.project.mainservice.dtos.BookDto;
import com.project.mainservice.models.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto toDto(Book book);
    Book toModel(BookDto dto);
}
