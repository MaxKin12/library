package com.project.authservice.controllers;

import com.project.authservice.dtos.TokenDto;
import com.project.authservice.dtos.UserDto;
import com.project.authservice.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<Void> register(@RequestBody UserDto userDto) {
        authenticationService.signup(userDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> authenticate(@RequestBody UserDto userDto) {
        TokenDto jwtToken = authenticationService.authenticate(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(jwtToken);
    }
}