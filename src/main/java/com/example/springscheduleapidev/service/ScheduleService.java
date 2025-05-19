package com.example.springscheduleapidev.service;

import com.example.springscheduleapidev.dto.request.CreateScheduleRequestDto;
import com.example.springscheduleapidev.dto.response.CreateScheduleResponseDto;
import com.example.springscheduleapidev.entity.Schedule;
import com.example.springscheduleapidev.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public CreateScheduleResponseDto create(CreateScheduleRequestDto dto) {

        Schedule schedule = new Schedule(dto);
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new CreateScheduleResponseDto(savedSchedule);
    }


}
