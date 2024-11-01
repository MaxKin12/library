package com.project.mainservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record BookNoIdDto (
        @Pattern(regexp = "^(978|979)\\d{10}$", message = "Input ISBN doesn't match ISBN-13")
        String isbn,
        @NotBlank(message = "Title must be not blank")
        @Size(max = 50, message = "Title is too long")
        String title,
        @Size(max = 20, message = "Genre name is too long")
        String genre,
        @Size(max = 200, message = "Description is too long")
        String description,
        @Size(max = 50, message = "Author name is too long")
        String author
) {}
