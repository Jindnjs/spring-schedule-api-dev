package com.example.springscheduleapidev.entity;

import com.example.springscheduleapidev.dto.request.CreateScheduleRequestDto;
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
}
