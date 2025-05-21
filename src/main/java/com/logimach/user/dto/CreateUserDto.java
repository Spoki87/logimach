package com.logimach.user.dto;

import lombok.Getter;

@Getter
public class CreateUserDto {
    private String email;
    private String username;
    private String password;
}
