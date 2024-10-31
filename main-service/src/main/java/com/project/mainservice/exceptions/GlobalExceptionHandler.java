package com.project.mainservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<BookError> handleResourceNotFoundException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new BookError(HttpStatus.NOT_FOUND.value(), e.getMessage()),
                HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DBException.class)
    public ResponseEntity<BookError> handleDBException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new BookError(HttpStatus.BAD_REQUEST.value(), e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BookError> handleOtherExceptions(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new BookError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Unknown internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
