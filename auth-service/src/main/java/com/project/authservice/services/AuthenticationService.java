package com.project.authservice.services;

import com.project.authservice.dtos.TokenDto;
import com.project.authservice.exceptions.AuthException;
import com.project.authservice.exceptions.SignUpException;
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
    private final JwtService jwtService;

    public User signup(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new SignUpException(e);
        }
        return userRepository.save(user);
    }

    public User authenticate(User user) {
        try {
            return (User) authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getEmail(),
                    user.getPassword())
            ).getPrincipal();
        } catch (Exception e) {
            throw new AuthException("Invalid login or password");
        }
    }

    public TokenDto getTokenDto(String jwtToken) {
        return new TokenDto(jwtToken, jwtService.getExpirationTime());
    }
}