package com.example.springscheduleapidev.entity;

import com.example.springscheduleapidev.dto.request.CreateScheduleRequestDto;
import com.example.springscheduleapidev.dto.request.UpdateScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String content;

    @Column(nullable = false, name = "user_name")
    private String name;

    public Schedule() {}

    public Schedule(CreateScheduleRequestDto dto){
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.name = dto.getName();
    }

    public void updateSchedule(UpdateScheduleRequestDto dto){
        if(dto.getTitle() != null && !dto.getTitle().isBlank()){
            this.title = dto.getTitle();
        }
        if(dto.getContent() != null && !dto.getContent().isBlank()){
            this.content = dto.getContent();
        }
    }
}
