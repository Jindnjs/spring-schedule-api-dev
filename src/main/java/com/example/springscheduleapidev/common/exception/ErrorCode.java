package com.example.springscheduleapidev.common.exception;

import com.example.springscheduleapidev.common.commonInterface.BaseCode;
import org.springframework.http.HttpStatus;

public enum ErrorCode implements BaseCode {

    INVALID_INPUT(HttpStatus.BAD_REQUEST, "입력값이 올바르지 않습니다."),
    MISSING_REQUEST_BODY(HttpStatus.BAD_REQUEST, "RequestBody가 누락되었습니다.");

    private final HttpStatus httpStatus;
    private final String message;

    ErrorCode(HttpStatus httpStatus, String message) {
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
