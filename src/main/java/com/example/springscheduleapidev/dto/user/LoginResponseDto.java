package com.example.springscheduleapidev.dto.user;

import com.example.springscheduleapidev.domain.user.User;
import lombok.Getter;

@Getter
public class LoginResponseDto {
    private Long id;
    private String name;
    private String email;

    public LoginResponseDto() {}
    public LoginResponseDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static LoginResponseDto toDto(User user) {
        return new LoginResponseDto(user.getId(), user.getName(), user.getEmail());
    }
}
