package com.project.additionalservice.exceptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<RecordError> handleResourceNotFoundException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new RecordError(HttpStatus.NOT_FOUND.value(), e.getMessage()),
                HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DBException.class)
    public ResponseEntity<RecordError> handleDBException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new RecordError(HttpStatus.BAD_REQUEST.value(), e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<RecordError> handleValidationException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new RecordError(HttpStatus.BAD_REQUEST.value(), e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<RecordError> handleOtherExceptions(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new RecordError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Unknown internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
