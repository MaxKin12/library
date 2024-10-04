package com.project.authservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthError {
    private int statusCode;
    private String message;
}
