package com.project.authservice.exceptions;

public class SignUpException extends RuntimeException {

    public SignUpException(String message) {
        super(message);
    }
    public SignUpException(Exception exception) {
        super(exception);
    }
}
