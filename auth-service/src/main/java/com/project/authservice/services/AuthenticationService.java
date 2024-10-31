package com.project.authservice.services;

import com.project.authservice.dtos.TokenDto;
import com.project.authservice.dtos.UserDto;
import com.project.authservice.exceptions.AuthException;
import com.project.authservice.exceptions.SignUpException;
import com.project.authservice.mappers.UserMapper;
import com.project.authservice.models.User;
import com.project.authservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;
    private final JwtService jwtService;

    public void signup(UserDto userDto) {
        User user = userMapper.toModel(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new SignUpException("User with this email already exists");
        }
    }

    public TokenDto authenticate(UserDto userDto) {
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