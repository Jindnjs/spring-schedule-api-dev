package com.example.springscheduleapidev.common.exception;

import com.example.springscheduleapidev.common.commonInterface.BaseCode;

public abstract class BaseException extends RuntimeException {

    public abstract BaseCode getErrorCode();

    @Override
    public String getMessage() {
        return getErrorCode().getMessage();
    }
}
