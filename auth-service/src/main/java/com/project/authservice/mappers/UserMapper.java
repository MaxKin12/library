package com.project.authservice.mappers;

import com.project.authservice.dtos.UserDto;
import com.project.authservice.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toModel(UserDto userDto);
}
