package com.example.springscheduleapidev.domain.user;

import com.example.springscheduleapidev.common.security.PasswordEncoder;
import com.example.springscheduleapidev.domain.user.exception.EmailExistException;
import com.example.springscheduleapidev.domain.user.exception.EmailMismatchException;
import com.example.springscheduleapidev.domain.user.exception.PasswordMismatchException;
import com.example.springscheduleapidev.domain.user.exception.UserNotFoundException;
import com.example.springscheduleapidev.dto.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDto create(CreateUserRequestDto dto) {
        if(userRepository.findByEmail(dto.getEmail()).isPresent())
            throw new EmailExistException();
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
                .orElseThrow(UserNotFoundException::new);
    }

    public LoginResponseDto login(LoginRequestDto dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(EmailMismatchException::new);
        if(!passwordEncoder.matches(dto.getPassword(), user.getPassword()))
            throw new PasswordMismatchException();
        return LoginResponseDto.toDto(user);
    }

}
