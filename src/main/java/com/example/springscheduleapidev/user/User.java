package com.example.springscheduleapidev.user;

import com.example.springscheduleapidev.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void update(String name, String email, String password) {
        if (name != null && !name.isBlank())
            this.name = name;
        if(email != null && !email.isBlank())
            this.email = email;
        if (password != null && !password.isBlank())
            this.password = password;
    }
}
