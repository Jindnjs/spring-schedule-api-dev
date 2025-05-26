package com.example.springscheduleapidev.dto.user;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.constraints.AssertTrue;
import lombok.Getter;

@Getter
public class UserUpdateRequestDto {
    private String name;
    private String email;

    @AssertTrue(message = "이름,이메일중 하나는 반드시 입력해야 합니다.")
    public boolean isTitleOrContentPresent() {
        return !StringUtils.isBlank(name) || !StringUtils.isBlank(email);
    }
}
