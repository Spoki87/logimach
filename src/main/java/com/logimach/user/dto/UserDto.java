package com.logimach.user.dto;

import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class UserDto {
    private UUID id;
    private String email;
    private String username;
}
