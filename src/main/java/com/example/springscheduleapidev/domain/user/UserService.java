package com.example.springscheduleapidev.domain.user;

import com.example.springscheduleapidev.common.security.PasswordEncoder;
import com.example.springscheduleapidev.dto.user.CreateUserRequestDto;
import com.example.springscheduleapidev.dto.user.LoginRequestDto;
import com.example.springscheduleapidev.dto.user.UserUpdateRequestDto;
import com.example.springscheduleapidev.dto.user.LoginResponseDto;
import com.example.springscheduleapidev.dto.user.UserResponseDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDto create(CreateUserRequestDto dto) {
        if(userRepository.findByEmail(dto.getEmail()).isPresent())
            throw new RuntimeException("이미 존재하는 이메일입니다.");
        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        User user = new User(dto.getName(), dto.getEmail(), encodedPassword);
        User savedUser = userRepository.save(user);
        return UserResponseDto.toDto(savedUser);
    }

    public UserResponseDto getById(Long id) {
        User savedUser = findByIdOrThrow(id);
        return UserResponseDto.toDto(savedUser);
    }

    public UserResponseDto update(Long id, UserUpdateRequestDto dto) {
        User savedUser = findByIdOrThrow(id);
        savedUser.update(dto.getName(), dto.getEmail());
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

    public LoginResponseDto login(LoginRequestDto dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        if(!passwordEncoder.matches(dto.getPassword(), user.getPassword()))
            throw new RuntimeException("Wrong password");
        return LoginResponseDto.toDto(user);
    }

}
