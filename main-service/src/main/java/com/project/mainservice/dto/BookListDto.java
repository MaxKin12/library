package com.project.mainservice.dto;

import java.util.List;

public record BookListDto (
        List<BookDto> bookList
) {}
