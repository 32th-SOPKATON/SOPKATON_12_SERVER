package com.sopkaton.SOPKATON12_SERVER.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static lombok.AccessLevel.PRIVATE;

@Getter
@RequiredArgsConstructor(access = PRIVATE)
public enum SuccessStatus {

    /*
    mission
     */
    MISSION_INQUIRY_SUCCESS(HttpStatus.OK, "미션 조회 성공"),

    ;

    private final HttpStatus httpStatus;
    private final String message;
}