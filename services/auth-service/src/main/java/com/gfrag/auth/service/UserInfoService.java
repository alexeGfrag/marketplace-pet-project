package com.gfrag.auth.service;

import com.gfrag.auth.db.entity.User;
import com.gfrag.auth.db.repository.UserRepository;
import com.gfrag.auth.dto.UserDto;
import com.gfrag.auth.mapper.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserInfoService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto getUserInfo(String email) {
        log.info("Find user by email {}", email);
        if (email == null) {
            throw new IllegalArgumentException("email required, but null");
        }
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            log.warn("User with email {} not found", email);
            throw new EntityNotFoundException("User with email " + email + " not found");
        }
        return userMapper.toDto(user.get());
    }
}
