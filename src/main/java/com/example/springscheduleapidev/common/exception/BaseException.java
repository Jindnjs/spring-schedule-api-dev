package com.example.springscheduleapidev.common.exception;

public abstract class BaseException extends RuntimeException {

    public abstract BaseErrorCode getErrorCode();

    @Override
    public String getMessage() {
        return getErrorCode().getMessage();
    }
}
