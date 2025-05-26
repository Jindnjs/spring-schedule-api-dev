package com.example.springscheduleapidev.domain.schedule;

import com.example.springscheduleapidev.common.commonInterface.BaseEntity;
import com.example.springscheduleapidev.domain.user.User;
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Schedule() {}

    public Schedule(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
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
