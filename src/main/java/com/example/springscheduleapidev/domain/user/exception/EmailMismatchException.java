package com.example.springscheduleapidev.domain.user.exception;

import com.example.springscheduleapidev.common.commonInterface.BaseCode;
import com.example.springscheduleapidev.common.exception.BaseException;
import com.example.springscheduleapidev.common.exception.ErrorCode;

public class EmailMismatchException extends BaseException {

    @Override
    public BaseCode getErrorCode() {
        return ErrorCode.EMAIL_NOT_MATCH;
    }
}
