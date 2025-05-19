package com.example.springscheduleapidev.controller;

import com.example.springscheduleapidev.dto.request.CreateScheduleRequestDto;
import com.example.springscheduleapidev.dto.response.CreateScheduleResponseDto;
import com.example.springscheduleapidev.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<CreateScheduleResponseDto> createSchedule(
        @Validated @RequestBody CreateScheduleRequestDto dto
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(scheduleService.create(dto));
    }
}
