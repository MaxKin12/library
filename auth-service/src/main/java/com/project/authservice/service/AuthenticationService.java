package com.project.authservice.service;

import com.project.authservice.dto.TokenDto;
import com.project.authservice.dto.UserDto;
import com.project.authservice.exception.AuthException;
import com.project.authservice.exception.SignUpException;
import com.project.authservice.mapper.UserMapper;
import com.project.authservice.model.User;
import com.project.authservice.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;
    private final JwtService jwtService;

    public void signup(@Valid UserDto userDto) {
        User user = userMapper.toModel(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new SignUpException("User with this email already exists");
        }
    }

    public TokenDto authenticate(@Valid UserDto userDto) {
        try {
            User user = userMapper.toModel(userDto);
            User authenticatedUser = (User) authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getEmail(),
                    user.getPassword())
            ).getPrincipal();
            String jwtToken = jwtService.generateToken(authenticatedUser);
            return new TokenDto(jwtToken, jwtService.getExpirationTime());
        } catch (Exception e) {
            throw new AuthException("Invalid login or password");
        }
    }
}