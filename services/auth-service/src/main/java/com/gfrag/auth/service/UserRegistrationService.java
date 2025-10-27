package com.gfrag.auth.service;

import com.gfrag.auth.db.entity.User;
import com.gfrag.auth.db.repository.UserRepository;
import com.gfrag.auth.dto.RegisterRequest;
import com.gfrag.auth.dto.UserDto;
import com.gfrag.auth.enums.UserRole;
import com.gfrag.auth.exception.RegistrationException;
import com.gfrag.auth.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Slf4j
@Service
public class UserRegistrationService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final UserMapper userMapper;

    public UserRegistrationService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto register(RegisterRequest registerRequest) {
        log.debug("Try to register user with email: {}", registerRequest.email());

        if (userRepository.existsByEmail(registerRequest.email())) {
            throw new RegistrationException("Email already registered");
        }
        try {
            User user = new User();
            user.setEmail(registerRequest.email());
            user.setPassword(passwordEncoder.encode(registerRequest.password()));
            user.setRoles(Collections.singleton(UserRole.USER));
            return userMapper.toDto(userRepository.save(user));
        } catch (Exception e) {
            log.error("error saving new user", e.getMessage());
            throw new RegistrationException(e.getMessage());
        }
    }
}
