package com.example.springscheduleapidev.common.response;

import com.example.springscheduleapidev.common.commonInterface.BaseCode;
import org.springframework.http.HttpStatus;

public enum ResponseCode implements BaseCode {
    CREATED(HttpStatus.CREATED, "created"),
    SUCCESS(HttpStatus.OK, "success");

    private final HttpStatus httpStatus;
    private final String message;

    ResponseCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    @Override
    public HttpStatus getStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
