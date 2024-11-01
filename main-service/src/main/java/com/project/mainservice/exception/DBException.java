package com.project.mainservice.exception;

public class DBException extends RuntimeException {
    public DBException(String message) {
        super(message);
    }
    public DBException(Exception exception) {
        super(exception);
    }
}
