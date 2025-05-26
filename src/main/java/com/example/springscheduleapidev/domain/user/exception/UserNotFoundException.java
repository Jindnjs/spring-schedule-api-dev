package com.example.springscheduleapidev.domain.user.exception;

import com.example.springscheduleapidev.common.commonInterface.BaseCode;
import com.example.springscheduleapidev.common.exception.BaseException;
import com.example.springscheduleapidev.common.exception.ErrorCode;

public class UserNotFoundException extends BaseException {
    @Override
    public BaseCode getErrorCode() {
        return ErrorCode.USER_NOT_FOUND;
    }
}
