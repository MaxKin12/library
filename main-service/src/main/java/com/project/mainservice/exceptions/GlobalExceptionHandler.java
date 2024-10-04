package com.project.mainservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<BookError> catchResourceNotFoundException(Exception e) {
        e.printStackTrace();

        if (e instanceof ResourceNotFoundException) {
            return new ResponseEntity<>(new BookError(HttpStatus.NOT_FOUND.value(), e.getMessage()),
                    HttpStatus.NOT_FOUND);
        }

        if (e instanceof DBException) {
            return new ResponseEntity<>(new BookError(HttpStatus.BAD_REQUEST.value(), e.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }

        else {
            return new ResponseEntity<>(new BookError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Unknown internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
