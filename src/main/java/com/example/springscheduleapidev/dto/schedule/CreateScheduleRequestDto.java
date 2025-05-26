package com.example.springscheduleapidev.dto.schedule;

import com.example.springscheduleapidev.domain.schedule.Schedule;
import com.example.springscheduleapidev.domain.user.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {

    @NotBlank(message = "제목을 입력하세요.")
    private String title;

    private String content;

    @NotNull(message = "아이디를 입력하세요")
    private Long userId;

    public Schedule toEntity(User user) {
        return new Schedule(title, content, user);
    }
}
