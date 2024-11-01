package com.project.authservice.controller;

import com.project.authservice.dto.TokenDto;
import com.project.authservice.dto.UserDto;
import com.project.authservice.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
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