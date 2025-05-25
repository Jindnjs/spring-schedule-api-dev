package com.example.springscheduleapidev.user.dto.request;

import lombok.Getter;

@Getter
public class UserUpdateRequestDto {
    private String name;
    private String email;
    private String password;
}
