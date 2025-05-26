package com.example.springscheduleapidev.common.response;

import com.example.springscheduleapidev.common.commonInterface.BaseCode;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@JsonPropertyOrder({ "statusCode", "message", "body" })
public class BaseResponse<T> {
    private int statusCode;
    private String message;
    private T body;

    public BaseResponse(HttpStatus httpStatus, String message, T body) {
        this.statusCode = httpStatus.value();
        this.message = message;
        this.body = body;
    }

    public static <T> BaseResponse<T> success(BaseCode responseCode, T body) {
        return new BaseResponse<>(responseCode.getStatus(), responseCode.getMessage(), body);
    }

    public static <T> BaseResponse<T> error(BaseCode errorCode, T body) {
        return new BaseResponse<>(errorCode.getStatus(), errorCode.getMessage(), body);
    }
}
