package com.project.authservice.controllers;

import com.project.authservice.dtos.UserListDto;
import com.project.authservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<UserListDto> getAllUsers() {
        UserListDto bookListDto = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(bookListDto);
    }
}
