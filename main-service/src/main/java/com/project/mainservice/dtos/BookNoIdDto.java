package com.project.mainservice.dtos;

import lombok.Data;

@Data
public class BookNoIdDto {
    private String isbn;
    private String title;
    private String genre;
    private String description;
    private String author;
}
