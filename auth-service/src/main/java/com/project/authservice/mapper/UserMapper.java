package com.project.authservice.mapper;

import com.project.authservice.dto.UserDto;
import com.project.authservice.dto.UserListDto;
import com.project.authservice.model.User;
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
