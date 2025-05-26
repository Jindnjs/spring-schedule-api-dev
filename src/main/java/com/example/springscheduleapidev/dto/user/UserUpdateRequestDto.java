package com.example.springscheduleapidev.dto.user;

import lombok.Getter;

@Getter
public class UserUpdateRequestDto {
    private String name;
    private String email;
    private String password;
}
