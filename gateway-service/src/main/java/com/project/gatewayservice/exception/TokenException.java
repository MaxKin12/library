package com.project.gatewayservice.exception;

public class TokenException extends RuntimeException {
    public TokenException(String message) {
        super(message);
    }
    public TokenException(Exception exception) {
        super(exception);
    }
}