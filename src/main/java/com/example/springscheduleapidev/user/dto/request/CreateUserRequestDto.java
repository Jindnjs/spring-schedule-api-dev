package com.example.springscheduleapidev.user.dto.request;

import com.example.springscheduleapidev.user.User;
import lombok.Getter;

@Getter
public class CreateUserRequestDto {
    private String name;
    private String email;
    private String password;

    public User toEntity(){
        User user = new User(name, email, password);
        return user;
    }
}
