package com.example.springscheduleapidev.schedule;

import com.example.springscheduleapidev.common.entity.BaseEntity;
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

    public Schedule(String title, String content, String name) {
        this.title = title;
        this.content = content;
        this.name = name;
    }

    public void updateSchedule(String title, String content){
        if(title != null && !title.isBlank()){
            this.title = title;
        }
        if(content != null && !content.isBlank()){
            this.content = content;
        }
    }
}
