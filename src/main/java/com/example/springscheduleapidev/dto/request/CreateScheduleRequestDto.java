package com.example.springscheduleapidev.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {

    @NotBlank(message = "제목을 입력하세요.")
    private String title;

    private String content;

    @NotBlank(message = "이름을 입력하세요.")
    private String name;
}
