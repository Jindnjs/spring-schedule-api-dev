package com.example.springscheduleapidev.controller;

import com.example.springscheduleapidev.dto.request.CreateScheduleRequestDto;
import com.example.springscheduleapidev.dto.response.ScheduleResponseDto;
import com.example.springscheduleapidev.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    /**
     * 새로운 일정을 생성하는 API
     *
     * @param dto 생성할 일정의 요청 정보
     * @return  생성된 일정 정보 {@link ScheduleResponseDto}와 201 CREATED 응답 반환
     */
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(
        @Validated @RequestBody CreateScheduleRequestDto dto
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(scheduleService.create(dto));
    }

    /**
     * 전체 일정을 조회하는 API
     *
     * @return 일정 목록 {@link ScheduleResponseDto} 리스트와 200 OK 응답 반환
     */
    @GetMapping()
    public ResponseEntity<List<ScheduleResponseDto>> getSchedules(){
        List<ScheduleResponseDto> schedules = scheduleService.findAllSchedules();
        return ResponseEntity.ok(schedules);
    }

    /**
     * 특정 id의 일정을 조회하는 API
     *
     * @param id 조회할 일정의 id
     * @return 조회된 일정 정보 {@link ScheduleResponseDto}
     */
    @GetMapping("{id}")
    public ResponseEntity<ScheduleResponseDto> getScheduleById(
            @PathVariable Long id
    ) {
        ScheduleResponseDto responseDto = scheduleService.findScheduleById(id);
        return ResponseEntity.ok(responseDto);
    }
}
