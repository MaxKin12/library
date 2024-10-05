package com.project.gatewayservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<GatewayError> catchException(Exception e) {
        e.printStackTrace();

        if (e instanceof TokenException) {
            return new ResponseEntity<>(new GatewayError(HttpStatus.FORBIDDEN.value(), e.getMessage()),
                    HttpStatus.FORBIDDEN);
        }

        else {
            return new ResponseEntity<>(new GatewayError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Unknown internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}