package com.example.springscheduleapidev.user;

import com.example.springscheduleapidev.user.dto.request.CreateUserRequestDto;
import com.example.springscheduleapidev.user.dto.request.UserUpdateRequestDto;
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
        User savedUser = findByIdOrThrow(id);
        return UserResponseDto.toDto(savedUser);
    }

    public UserResponseDto update(Long id, UserUpdateRequestDto dto) {
        User savedUser = findByIdOrThrow(id);
        savedUser.update(dto.getName(), dto.getEmail(), dto.getPassword());
        User updatedUser = userRepository.save(savedUser);
        return UserResponseDto.toDto(updatedUser);
    }

    public void delete(Long id) {
        User user = findByIdOrThrow(id);
        userRepository.delete(user);
    }

    private User findByIdOrThrow(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }
}
