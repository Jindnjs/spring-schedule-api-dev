package com.example.springscheduleapidev.common.exception;

import com.example.springscheduleapidev.common.commonInterface.BaseCode;

public class UserNotFoundException extends BaseException {
    @Override
    public BaseCode getErrorCode() {
        return ErrorCode.USER_NOT_FOUND;
    }
}
