package com.example.springscheduleapidev.user.dto.request;

import com.example.springscheduleapidev.user.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateUserRequestDto {
    @NotBlank(message = "이름을 입력하세요.")
    private String name;
    @NotBlank(message = "이메일을 입력하세요.")
    private String email;
    @NotBlank(message = "비밀번호를 입력하세요.")
    private String password;

    public User toEntity(){
        User user = new User(name, email, password);
        return user;
    }
}
