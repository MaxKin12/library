package com.project.authservice.dtos;

public record TokenDto (
        String token,
        long expiresIn
) {}
