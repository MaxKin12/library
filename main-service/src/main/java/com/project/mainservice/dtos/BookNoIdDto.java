package com.project.mainservice.dtos;

public record BookNoIdDto (
        String isbn,
        String title,
        String genre,
        String description,
        String author
) {}
