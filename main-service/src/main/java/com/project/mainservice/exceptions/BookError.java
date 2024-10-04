package com.project.mainservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookError {
    private int statusCode;
    private String message;
}
