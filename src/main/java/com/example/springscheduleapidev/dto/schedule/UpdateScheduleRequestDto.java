package com.example.springscheduleapidev.dto.schedule;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.constraints.AssertTrue;
import lombok.Getter;

@Getter
public class UpdateScheduleRequestDto {
    private String title;
    private String content;

    @AssertTrue(message = "제목,내용중 하나는 반드시 입력해야 합니다.")
    public boolean isTitleOrContentPresent() {
        return !StringUtils.isBlank(title) || !StringUtils.isBlank(content);
    }
}