package com.project.authservice.dto;

public record TokenDto (
        String token,
        long expiresIn
) {}
