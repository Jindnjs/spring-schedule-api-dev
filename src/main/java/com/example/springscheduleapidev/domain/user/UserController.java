package com.example.springscheduleapidev.domain.user;

import com.example.springscheduleapidev.common.response.BaseResponse;
import com.example.springscheduleapidev.common.response.ResponseCode;
import com.example.springscheduleapidev.common.security.LoginInfo;
import com.example.springscheduleapidev.dto.user.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<BaseResponse<UserResponseDto>> create(
            @Validated @RequestBody CreateUserRequestDto dto
    ){
        UserResponseDto createdUser = userService.create(dto);
        return ResponseEntity.ok(BaseResponse.response(ResponseCode.CREATED,createdUser));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<BaseResponse<UserResponseDto>> getById(
            @PathVariable Long id
    ){
        UserResponseDto user = userService.getById(id);
        return ResponseEntity.ok(BaseResponse.response(ResponseCode.SUCCESS,user));

    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<BaseResponse<UserResponseDto>> update(
            @PathVariable Long id,
            @Validated @RequestBody UserUpdateRequestDto dto
    ){
        UserResponseDto updatedUser = userService.update(id, dto);
        return ResponseEntity.ok(BaseResponse.response(ResponseCode.SUCCESS,updatedUser));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<BaseResponse<?>> delete(
            @PathVariable Long id
    ){
        userService.delete(id);
        return ResponseEntity.ok(BaseResponse.response(ResponseCode.SUCCESS,null));
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<LoginResponseDto>> login(
            HttpSession session,
            @Validated @RequestBody LoginRequestDto dto
    ){
        LoginResponseDto loginInfo = userService.login(dto);
        session.setAttribute(LoginInfo.LOGIN_INFO, loginInfo);
        return ResponseEntity.ok(BaseResponse.response(ResponseCode.SUCCESS,loginInfo));
    }

    @PostMapping("/logout")
    public ResponseEntity<BaseResponse<?>> logout(
            HttpServletRequest request
    ){
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return ResponseEntity.ok(BaseResponse.response(ResponseCode.SUCCESS,null));
    }

}
