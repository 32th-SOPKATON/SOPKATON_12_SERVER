package com.sopkaton.SOPKATON12_SERVER.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sopkaton.SOPKATON12_SERVER.common.exception.ErrorStatus;
import com.sopkaton.SOPKATON12_SERVER.common.exception.SuccessStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Getter
@RequiredArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponseDto<T> {

    private final int code;
    private final boolean success;
    private final String message;
    private T data;

    public static ApiResponseDto success(SuccessStatus successStatus) {
        return new ApiResponseDto<>(successStatus.getHttpStatus().value(), true, successStatus.getMessage());
    }

    public static <T> ApiResponseDto<T> success(SuccessStatus successStatus, T data) {
        return new ApiResponseDto<T>(successStatus.getHttpStatus().value(), true, successStatus.getMessage(), data);
    }

    public static ApiResponseDto error(ErrorStatus errorStatus) {
        return new ApiResponseDto<>(errorStatus.getHttpStatus().value(), false, errorStatus.getMessage());
    }
}
