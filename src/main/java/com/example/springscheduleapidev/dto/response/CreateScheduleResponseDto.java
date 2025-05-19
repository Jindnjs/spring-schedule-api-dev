package com.example.springscheduleapidev.dto.response;

import com.example.springscheduleapidev.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponseDto {
    private final Long id;
    private final String title;
    private final String content;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public CreateScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.name = schedule.getName();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }
}
