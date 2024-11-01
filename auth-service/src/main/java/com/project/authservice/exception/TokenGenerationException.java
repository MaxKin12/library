package com.project.authservice.exception;

public class TokenGenerationException extends RuntimeException {

    public TokenGenerationException(String message) {
        super(message);
    }
    public TokenGenerationException(Exception exception) {
        super(exception);
    }
}
