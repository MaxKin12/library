package com.project.gatewayservice.exceptions;

public class TokenException extends RuntimeException {
    public TokenException(String message) {
        super(message);
    }
    public TokenException(Exception exception) {
        super(exception);
    }
}