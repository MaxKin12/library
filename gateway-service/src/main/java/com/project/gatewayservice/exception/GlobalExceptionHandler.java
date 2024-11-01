package com.project.gatewayservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TokenException.class)
    public ResponseEntity<GatewayError> handleTokenException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new GatewayError(HttpStatus.FORBIDDEN.value(), e.getMessage()),
                HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<GatewayError> handleServiceUnavailableException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new GatewayError(HttpStatus.SERVICE_UNAVAILABLE.value(), e.getMessage()),
                HttpStatus.SERVICE_UNAVAILABLE);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<GatewayError> handleOtherExceptions(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new GatewayError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Unknown internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
