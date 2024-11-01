package com.project.authservice.dto;

import java.util.List;

public record UserListDto (
        List<UserDto> userList
) {}
