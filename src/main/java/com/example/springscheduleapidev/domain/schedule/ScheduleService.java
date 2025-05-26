package com.example.springscheduleapidev.domain.schedule;

import com.example.springscheduleapidev.dto.schedule.CreateScheduleRequestDto;
import com.example.springscheduleapidev.dto.schedule.UpdateScheduleRequestDto;
import com.example.springscheduleapidev.dto.schedule.ScheduleResponseDto;
import com.example.springscheduleapidev.domain.user.User;
import com.example.springscheduleapidev.domain.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    /**
     * 새로운 일정을 생성합니다.
     *
     * @param dto 생성할 일정 정보
     * @return 생성된 일정 정보 {@link ScheduleResponseDto}
     */
    public ScheduleResponseDto create(CreateScheduleRequestDto dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Schedule schedule = dto.toEntity(user);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule);
    }

    /**
     * 전체 일정 목록을 반환합니다.
     *
     * @return 전체 일정 정보 {@link ScheduleResponseDto} 리스트
     */
    public List<ScheduleResponseDto> findAllSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return schedules.stream()
                .map(ScheduleResponseDto::new)
                .toList();
    }

    /**
     * id에 맞는 일정 정보를 반환합니다.
     *
     * @param id 조회할 일정의 id
     * @return {@link ScheduleResponseDto} 조회된 일정 정보
     * @throws RuntimeException 해당 id로 저장된 일정이 존재하지 않을경우 예외 발생
     */
    public ScheduleResponseDto findScheduleById(Long id) {
        Schedule schedule = findScheduleByIdOrThrow(id);
        return new ScheduleResponseDto(schedule);
    }

    /**
     * id에 맞는 일정을 수정합니다.
     *
     * @param id  수정할 일정의 id
     * @param dto 수정할 일정의 요청 정보
     * @return {@link ScheduleResponseDto} 수정된 일정 정보
     * @throws RuntimeException 해당 id로 저장된 일정이 존재하지 않을경우 예외 발생
     */
    public ScheduleResponseDto updateSchedule(Long id, UpdateScheduleRequestDto dto) {
        Schedule schedule = findScheduleByIdOrThrow(id);
        schedule.updateSchedule(dto.getTitle(),dto.getContent());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule);
    }

    /**
     * id에 맞는 일정을 삭제합니다.
     *
     * @param id 삭제할 일정의 id
     */
    public void deleteSchedule(Long id){
        Schedule schedule = findScheduleByIdOrThrow(id);
        scheduleRepository.delete(schedule);
    }


    private Schedule findScheduleByIdOrThrow(Long id) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if (optionalSchedule.isPresent())
            return optionalSchedule.get();
        else
            throw new RuntimeException("Data Not Found. Id: " + id);
    }
}
