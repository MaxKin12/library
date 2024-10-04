package com.project.mainservice.exceptions;

public class DBException extends RuntimeException {
    public DBException(String message) {
        super(message);
    }
    public DBException(Exception exception) {
        super(exception);
    }
}
