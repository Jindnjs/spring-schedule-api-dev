package com.example.springscheduleapidev.common.commonInterface;

import org.springframework.http.HttpStatus;

public interface BaseCode {
    HttpStatus getStatus();
    String getMessage();
}
