package com.example.springscheduleapidev.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginRequestDto {
    @NotBlank(message = "이메일을 입력하세요")
    @Email(message = "이메일 형식을 입력하세요")
    private String email;

    @NotBlank(message = "비밀번호를 입력하세요")
    private String password;
}
