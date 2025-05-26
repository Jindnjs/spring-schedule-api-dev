package com.example.springscheduleapidev.domain.user;

import com.example.springscheduleapidev.common.security.LoginInfo;
import com.example.springscheduleapidev.dto.user.CreateUserRequestDto;
import com.example.springscheduleapidev.dto.user.LoginRequestDto;
import com.example.springscheduleapidev.dto.user.UserUpdateRequestDto;
import com.example.springscheduleapidev.dto.user.LoginResponseDto;
import com.example.springscheduleapidev.dto.user.UserResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> create(
            @Validated @RequestBody CreateUserRequestDto dto
    ){
        UserResponseDto createdUser = userService.create(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdUser);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDto> getById(
            @PathVariable Long id
    ){
        UserResponseDto user = userService.getById(id);
        return ResponseEntity.ok(user);

    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<UserResponseDto> update(
            @PathVariable Long id,
            @RequestBody UserUpdateRequestDto dto
    ){
        UserResponseDto updatedUser = userService.update(id, dto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id
    ){
        userService.delete(id);
        return ResponseEntity.ok("유저 삭제완료 id: " + id);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(
            HttpSession session,
            @Validated @RequestBody LoginRequestDto dto
    ){
        LoginResponseDto loginInfo = userService.login(dto);
        session.setAttribute(LoginInfo.LOGIN_INFO, loginInfo);
        return ResponseEntity.ok("로그인");
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(
            HttpServletRequest request
    ){
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return ResponseEntity.ok("로그아웃");
    }

}
