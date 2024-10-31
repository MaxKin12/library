package com.project.authservice.mappers;

import com.project.authservice.dtos.UserDto;
import com.project.authservice.dtos.UserListDto;
import com.project.authservice.models.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toModel(UserDto userDto);
    UserDto toDto(User user);
    List<UserDto> toListDto(List<User> bookList);
    default UserListDto toBookListDto(List<User> userList) {
        return new UserListDto(toListDto(userList));
    }
}
