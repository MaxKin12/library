package com.project.authservice.controller;

import com.project.authservice.dto.UserListDto;
import com.project.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
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
