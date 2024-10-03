package com.project.authservice.controllers;

import com.project.authservice.dtos.UserDto;
import com.project.authservice.mappers.UserMapper;
import com.project.authservice.models.User;
import com.project.authservice.responses.LoginResponse;
import com.project.authservice.services.AuthenticationService;
import com.project.authservice.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody UserDto userDto) {
        User registeredUser = authenticationService.signup(userMapper.toModel(userDto));
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody UserDto userDto) {
        User authenticatedUser = authenticationService.authenticate(userMapper.toModel(userDto));
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = authenticationService.getLoginResponse(jwtToken);
        return ResponseEntity.ok(loginResponse);
    }
}