package com.project.authservice.responses;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;

    private long expiresIn;
}