package com.project.mainservice.dtos;

import java.util.List;

public record BookListDto (
        List<BookDto> bookList
) {}
