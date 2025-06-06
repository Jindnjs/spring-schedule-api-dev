package com.example.springscheduleapidev.domain.schedule;

import com.example.springscheduleapidev.common.response.BaseResponse;
import com.example.springscheduleapidev.common.response.ResponseCode;
import com.example.springscheduleapidev.dto.schedule.CreateScheduleRequestDto;
import com.example.springscheduleapidev.dto.schedule.ScheduleResponseDto;
import com.example.springscheduleapidev.dto.schedule.UpdateScheduleRequestDto;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<BaseResponse<ScheduleResponseDto>> createSchedule(
            @Validated @RequestBody CreateScheduleRequestDto dto
    ) {
        return ResponseEntity.ok(
                BaseResponse.response(ResponseCode.CREATED, scheduleService.create(dto)));

    }

    /**
     * 전체 일정을 조회하는 API
     *
     * @return 일정 목록 {@link ScheduleResponseDto} 리스트와 200 OK 응답 반환
     */
    @GetMapping()
    public ResponseEntity<BaseResponse<List<ScheduleResponseDto>>> getSchedules(){
        List<ScheduleResponseDto> schedules = scheduleService.findAllSchedules();
        return ResponseEntity.ok(
                BaseResponse.response(ResponseCode.SUCCESS, schedules));
    }

    /**
     * 특정 id의 일정을 조회하는 API
     *
     * @param id 조회할 일정의 id
     * @return 조회된 일정 정보 {@link ScheduleResponseDto}
     */
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<ScheduleResponseDto>> getScheduleById(
            @PathVariable Long id
    ) {
        ScheduleResponseDto responseDto = scheduleService.findScheduleById(id);
        return ResponseEntity.ok(BaseResponse.response(ResponseCode.SUCCESS, responseDto));
    }

    /**
     * 특정 id의 일정을 수정하는 API
     *
     * @param id 수정할 일정의 id
     * @param dto 수정할 일정의 요청 정보
     * @return 수정된 일정 정보 {@link ScheduleResponseDto} 와 200 OK 응답 반환
     */
    @PatchMapping("/{id}")
    public ResponseEntity<BaseResponse<ScheduleResponseDto>> updateSchedule(
            @PathVariable Long id,
            @Validated @RequestBody UpdateScheduleRequestDto dto
    ){
        ScheduleResponseDto responseDto = scheduleService.updateSchedule(id, dto);
        return ResponseEntity.ok(BaseResponse.response(ResponseCode.SUCCESS, responseDto));
    }

    /**
     * 특정 id의 일정을 삭제하는 API
     *
     * @param id 수정할 일정의 id
     * @return 200 Ok 응답과 삭제 완료 문자열 반환
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<?>> deleteSchedule(
            @PathVariable Long id
    ){
        scheduleService.deleteSchedule(id);
        return ResponseEntity.ok(BaseResponse.response(ResponseCode.SUCCESS,null));
    }
}


