package com.example.springscheduleapidev.common.response;

import com.example.springscheduleapidev.common.commonInterface.BaseCode;
import org.springframework.http.HttpStatus;

public enum ResponseCode implements BaseCode {
    ;

    @Override
    public HttpStatus getStatus() {
        return null;
    }

    @Override
    public String getMessage() {
        return "";
    }
}
