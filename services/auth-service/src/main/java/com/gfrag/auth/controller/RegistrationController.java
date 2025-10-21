package com.gfrag.auth.controller;

import com.gfrag.auth.dto.RegisterRequest;
import com.gfrag.auth.dto.UserDto;
import com.gfrag.auth.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserRegistrationService userRegistrationService;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> register(RegisterRequest registerRequest) {
        return ResponseEntity.ok(userRegistrationService.register(registerRequest));
    }
}
