package com.example.springscheduleapidev.user;

import com.example.springscheduleapidev.user.dto.request.CreateUserRequestDto;
import com.example.springscheduleapidev.user.dto.response.UserResponseDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto create(CreateUserRequestDto dto) {
        User savedUser = userRepository.save(dto.toEntity());
        return UserResponseDto.toDto(savedUser);
    }

    public UserResponseDto getById(Long id) {
        User savedUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return UserResponseDto.toDto(savedUser);
    }
}
