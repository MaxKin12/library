package com.project.mainservice.dto;

public record BookDto (
        Long id,
        String isbn,
        String title,
        String genre,
        String description,
        String author
) {}
