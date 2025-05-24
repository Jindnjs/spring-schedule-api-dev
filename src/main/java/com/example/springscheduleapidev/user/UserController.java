package com.example.springscheduleapidev.user;

import com.example.springscheduleapidev.user.dto.request.CreateUserRequestDto;
import com.example.springscheduleapidev.user.dto.response.CreateUserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<CreateUserResponseDto> create(
            @Validated @RequestBody CreateUserRequestDto dto
    ){
        CreateUserResponseDto createdUser = userService.create(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdUser);
    }
}
