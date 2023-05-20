package com.sopkaton.SOPKATON12_SERVER.common.exception;

import com.sopkaton.SOPKATON12_SERVER.common.dto.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.sopkaton.SOPKATON12_SERVER.common.exception.ErrorStatus.VALIDATION_EXCEPTION;

@RestControllerAdvice
public class ControllerExceptionAdvice {

    /*
     * 400 BAD_REQUEST
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ApiResponseDto handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        return ApiResponseDto.error(VALIDATION_EXCEPTION);
    }

    @ExceptionHandler(BusinessException.class)
    protected ApiResponseDto handleBusinessException(final BusinessException e) {
        return ApiResponseDto.error(e.getErrorStatus());
    }
}