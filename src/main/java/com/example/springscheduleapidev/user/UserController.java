package com.example.springscheduleapidev.user;

import com.example.springscheduleapidev.user.dto.request.CreateUserRequestDto;
import com.example.springscheduleapidev.user.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> create(
            @Validated @RequestBody CreateUserRequestDto dto
    ){
        UserResponseDto createdUser = userService.create(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(
            @PathVariable Long id
    ){
        UserResponseDto user = userService.getById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);

    }
}
