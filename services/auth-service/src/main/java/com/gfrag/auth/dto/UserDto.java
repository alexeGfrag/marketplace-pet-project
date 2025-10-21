package com.gfrag.auth.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {

    private String email;
    private LocalDateTime dateCreate;
    private final String result = "User registered successfully";

}
