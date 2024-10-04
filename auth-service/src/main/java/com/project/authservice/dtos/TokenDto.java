package com.project.authservice.dtos;

import lombok.Data;

@Data
public class TokenDto {
    private String token;
    private long expiresIn;
}
