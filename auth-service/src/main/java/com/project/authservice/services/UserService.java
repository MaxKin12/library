package com.project.authservice.services;

import com.project.authservice.dtos.UserListDto;
import com.project.authservice.mappers.UserMapper;
import com.project.authservice.models.User;
import com.project.authservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserListDto findAll() {
        List<User> users = userRepository.findAll();
        return userMapper.toBookListDto(users);
    }
}