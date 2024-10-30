package com.project.mainservice.dtos;

public record BookDto (
        Long id,
        String isbn,
        String title,
        String genre,
        String description,
        String author
) {}
