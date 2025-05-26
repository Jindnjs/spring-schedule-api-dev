package com.example.springscheduleapidev.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateUserRequestDto {
    @NotBlank(message = "이름을 입력하세요.")
    private String name;
    @NotBlank(message = "이메일을 입력하세요.")
    @Email(message = "이메일 형식을 입력하세요.")
    private String email;
    @NotBlank(message = "비밀번호를 입력하세요.")
    @Size(min = 4, message = "비밀번호는 4자리 이상입력하세요.")
    private String password;
}
