package com.sopkaton.SOPKATON12_SERVER.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessException extends RuntimeException {
    private final ErrorStatus errorStatus;
}
