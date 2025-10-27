package com.gfrag.auth.controller;

import com.gfrag.auth.dto.RegisterRequest;
import com.gfrag.auth.dto.UserDto;
import com.gfrag.auth.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class RegistrationController {

    private final UserRegistrationService userRegistrationService;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> register(@Validated RegisterRequest registerRequest) {
        log.info("Register request: {}", registerRequest);
        return ResponseEntity.ok(userRegistrationService.register(registerRequest));
    }
}
