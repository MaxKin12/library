package com.project.authservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<AuthError> handleException(Exception e) {
        e.printStackTrace();

        if (e instanceof BadCredentialsException) {
            return new ResponseEntity<>(new AuthError(HttpStatus.UNAUTHORIZED.value(),
                    "The username or password is incorrect"), HttpStatus.UNAUTHORIZED);
        }

        if (e instanceof AuthException) {
            return new ResponseEntity<>(new AuthError(HttpStatus.BAD_REQUEST.value(),
                    e.getMessage()), HttpStatus.BAD_REQUEST);
        }

        if (e instanceof AccountStatusException) {
            return new ResponseEntity<>(new AuthError(HttpStatus.FORBIDDEN.value(),
                    "The account is locked"), HttpStatus.FORBIDDEN);
        }

        if (e instanceof SignUpException) {
            return new ResponseEntity<>(new AuthError(HttpStatus.BAD_REQUEST.value(),
                    e.getMessage()), HttpStatus.BAD_REQUEST);
        }

        if (e instanceof TokenGenerationException) {
            return new ResponseEntity<>(new AuthError(HttpStatus.BAD_REQUEST.value(),
                    e.getMessage()), HttpStatus.BAD_REQUEST);
        }

        else {
            return new ResponseEntity<>(new AuthError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Unknown internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}