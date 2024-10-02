package com.project.authservice.dtos;

import lombok.Data;

@Data
public class RegisterUserDto {
    private String email;
    private String password;
}
