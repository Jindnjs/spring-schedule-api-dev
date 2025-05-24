package com.example.springscheduleapidev.user;

import com.example.springscheduleapidev.user.dto.request.CreateUserRequestDto;
import com.example.springscheduleapidev.user.dto.response.CreateUserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public CreateUserResponseDto create(CreateUserRequestDto dto) {
        User savedUser = userRepository.save(dto.toEntity());
        return CreateUserResponseDto.toDto(savedUser);
    }
}
