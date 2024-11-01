package com.project.authservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDto (
        @NotBlank(message = "Email is a necessary field")
        @Size(max = 100, message = "Email is to long")
        @Email(message = "Invalid email entered")
        String email,
        @NotNull(message = "Password is a necessary field")
        String password
) {}
