package com.project.authservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<AuthError> handleException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new AuthError(HttpStatus.UNAUTHORIZED.value(),
                "The username or password is incorrect"), HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(AuthException.class)
    public ResponseEntity<AuthError> handleAuthException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new AuthError(HttpStatus.BAD_REQUEST.value(),
                e.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AccountStatusException.class)
    public ResponseEntity<AuthError> handleAccountStatusException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new AuthError(HttpStatus.FORBIDDEN.value(),
                "The account is locked"), HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(SignUpException.class)
    public ResponseEntity<AuthError> handleSignUpException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new AuthError(HttpStatus.BAD_REQUEST.value(),
                e.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TokenGenerationException.class)
    public ResponseEntity<AuthError> handleTokenGenerationException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new AuthError(HttpStatus.BAD_REQUEST.value(),
                e.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<AuthError> handleOtherExceptions(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new AuthError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Unknown internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
