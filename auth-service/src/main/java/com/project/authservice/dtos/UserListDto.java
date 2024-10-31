package com.project.authservice.dtos;

import java.util.List;

public record UserListDto (
        List<UserDto> userList
) {}
