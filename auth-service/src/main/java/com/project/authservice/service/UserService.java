package com.project.authservice.service;

import com.project.authservice.dto.UserListDto;
import com.project.authservice.mapper.UserMapper;
import com.project.authservice.model.User;
import com.project.authservice.repository.UserRepository;
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